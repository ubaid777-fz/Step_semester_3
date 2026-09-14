import java.util.*;

public class PalindromeChecker {
    static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) { if (text.charAt(left) != text.charAt(right)) return false; left++; right--; }
        return true;
    }
    static boolean isPalindromeRecursive(String text) {
        if (text.length() <= 1) return true;
        if (text.charAt(0) != text.charAt(text.length() - 1)) return false;
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }
    static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray(); int left = 0, right = arr.length - 1;
        while (left < right) { char temp = arr[left]; arr[left] = arr[right]; arr[right] = temp; left++; right--; }
        return text.equals(new String(arr));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); System.out.print("Enter a word or text: "); String text = sc.nextLine();
        boolean iterative = isPalindromeIterative(text), recursive = isPalindromeRecursive(text), arrayReversal = isPalindromeArrayReversal(text);
        System.out.println();
        System.out.println("Iterative: " + (iterative ? "Palindrome" : "Not Palindrome"));
        System.out.println("Recursive: " + (recursive ? "Palindrome" : "Not Palindrome"));
        System.out.println("Array Reversal: " + (arrayReversal ? "Palindrome" : "Not Palindrome"));
        sc.close();
    }
}