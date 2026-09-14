import java.util.*;

public class WF {
    static void printFilteredWordFrequency(String feedback) {
        feedback = feedback.toLowerCase(); feedback = feedback.replace(".", ""); feedback = feedback.replace(",", "");
        String[] words = feedback.split("\\s+"); String[] stopWords = {"the", "was", "and", "a", "is", "of", "in"};
        HashMap<String, Integer> frequency = new HashMap<>();
        for (int i = 0; i < words.length; i++) { String word = words[i]; boolean stop = false; for (int j = 0; j < stopWords.length; j++) if (word.equals(stopWords[j])) { stop = true; break; } if (!stop && !word.isEmpty()) frequency.put(word, frequency.getOrDefault(word, 0) + 1); }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(frequency.entrySet()); list.sort((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<String, Integer> entry : list) System.out.println(entry.getKey() + ": " + entry.getValue());
    }
    public static void main(String[] args) { Scanner sc = new Scanner(System.in); System.out.print("Enter feedback: "); String feedback = sc.nextLine(); printFilteredWordFrequency(feedback); sc.close(); }
}