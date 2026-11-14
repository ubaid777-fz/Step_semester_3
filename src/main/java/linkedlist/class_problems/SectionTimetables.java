import java.util.*;

class Timetable {
    String name;
    List<String> periods;

    Timetable(String name, List<String> periods) {
        this.name = name;
        this.periods = periods;
    }

    Timetable copy(String newName) {
        List<String> newPeriods = new ArrayList<>(periods);
        return new Timetable(newName, newPeriods);
    }

    void setPeriod(int period, String subject) {
        periods.set(period - 1, subject);
    }

    void display() {
        System.out.println(name + ": " + periods);
    }
}

public class SectionTimetables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.next();

        int n = sc.nextInt();
        List<String> periods = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            periods.add(sc.next());
        }

        Timetable original = new Timetable(name, periods);

        String newName = sc.next();
        Timetable copy = original.copy(newName);

        int period = sc.nextInt();
        String subject = sc.next();

        copy.setPeriod(period, subject);

        original.display();
        copy.display();

        sc.close();
    }
}
