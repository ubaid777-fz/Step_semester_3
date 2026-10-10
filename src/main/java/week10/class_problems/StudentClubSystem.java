import java.util.*;

class ClubStudent {
    String rollNumber, name;
    ClubStudent(String rollNumber, String name) { this.rollNumber = rollNumber; this.name = name; }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ClubStudent)) return false;
        ClubStudent s = (ClubStudent) obj;
        return rollNumber.equals(s.rollNumber);
    }

    public int hashCode() { return rollNumber.hashCode(); }
}

public class StudentClubSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<ClubStudent> students = new HashSet<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split(" ");

            if (p[0].equals("ADD")) {
                ClubStudent student = new ClubStudent(p[1], p[2]);
                if (students.add(student)) System.out.println("Added");
                else System.out.println("duplicate rejected");
            } else if (p[0].equals("CONTAINS")) {
                ClubStudent student = new ClubStudent(p[1], p[2]);
                System.out.println("contains: " + students.contains(student));
            }
        }
        System.out.println("member count " + students.size());
    }
}