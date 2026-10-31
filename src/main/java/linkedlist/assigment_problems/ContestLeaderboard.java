public class ContestLeaderboard {
    static class Entry {
        String name;
        int marks;
        Entry(String name, int marks) { this.name = name; this.marks = marks; }
    }
    static Entry[] leaderboard(Entry[] entries) {
        int[] count = new int[101];
        for (Entry entry : entries) count[100 - entry.marks]++;
        for (int i = 1; i < 101; i++) count[i] += count[i - 1];
        Entry[] output = new Entry[entries.length];
        for (int i = entries.length - 1; i >= 0; i--) {
            Entry entry = entries[i];
            int key = 100 - entry.marks;
            output[count[key] - 1] = entry;
            count[key]--;
        }
        return output;
    }
    public static void main(String[] args) {
        Entry[] entries = {
            new Entry("Asha", 90), new Entry("Ravi", 75),
            new Entry("Neha", 90), new Entry("Kiran", 100),
            new Entry("Meera", 75)
        };
        Entry[] result = leaderboard(entries);
        for (Entry entry : result)
            System.out.print(entry.name + " " + entry.marks + ", ");
    }
}