import java.util.*;

public class MarksGridSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> names = new ArrayList<>();
        ArrayList<int[]> marks = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String name = line.substring(0, line.indexOf(" "));
            String data = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
            String[] values = data.split(",");
            int[] studentMarks = new int[3];
            for (int i = 0; i < 3; i++) studentMarks[i] = Integer.parseInt(values[i].trim());
            names.add(name);
            marks.add(studentMarks);
        }

        int[] subjectTotal = new int[3];
        int highest = -1;
        String topper = "";
        System.out.print("Totals ");

        for (int i = 0; i < names.size(); i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += marks.get(i)[j];
                subjectTotal[j] += marks.get(i)[j];
            }
            System.out.print(names.get(i) + " " + total);
            if (i < names.size() - 1) System.out.print(", ");
            if (total > highest) { highest = total; topper = names.get(i); }
        }

        System.out.println();
        if (!names.isEmpty()) {
            System.out.printf("averages %.2f, %.2f, %.2f%n",
                (double) subjectTotal[0] / names.size(),
                (double) subjectTotal[1] / names.size(),
                (double) subjectTotal[2] / names.size());
        }
        System.out.println("topper " + topper + " (" + highest + ")");
    }
}