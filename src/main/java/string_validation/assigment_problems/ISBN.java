import java.util.*;

public class ISBN {
    static String normalizeCode(String raw) { raw = raw.trim(); if (raw.length() < 3) return raw.toUpperCase(); String publisher = raw.substring(0, 3).toUpperCase(); String remaining = raw.substring(3); return publisher + remaining; }
    static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) if (!Character.isLetter(code.charAt(i))) return "Invalid: publisher code must be 3 letters";
        for (int i = 3; i < 13; i++) if (!Character.isDigit(code.charAt(i))) return "Invalid: body must contain only digits";
        String publisher = code.substring(0, 3), year = code.substring(3, 7), catalog = code.substring(7, 13);
        StringBuilder result = new StringBuilder(); result.append("[").append(publisher).append("] YEAR: ").append(year).append(" | CATALOG: ").append(catalog); return result.toString();
    }
    public static void main(String[] args) { Scanner sc = new Scanner(System.in); System.out.print("Enter ISBN code: "); String raw = sc.nextLine(); String code = normalizeCode(raw); System.out.println(validateAndFormat(code)); sc.close(); }
}