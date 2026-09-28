import java.util.ArrayList;

interface NotificationChannel {
    void send(Student student, String message);
}

class EmailChannel implements NotificationChannel {
    public void send(Student student, String message) {
        System.out.println("[Email → " + student.name + "] " + message);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(Student student, String message) {
        System.out.println("[SMS → " + student.name + "] " + message);
    }
}

class AppChannel implements NotificationChannel {
    public void send(Student student, String message) {
        System.out.println("[App → " + student.name + "] " + message);
    }
}

class Student {
    String name;
    String department;
    ArrayList<NotificationChannel> channels;

    Student(String name, String department) {
        this.name = name;
        this.department = department;
        channels = new ArrayList<>();
    }

    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }
}

class Notice {
    String title;
    ArrayList<String> departments;

    Notice(String title, ArrayList<String> departments) {
        this.title = title;
        this.departments = departments;
    }

    boolean isValid() {
        return title != null &&
               !title.isEmpty() &&
               departments != null &&
               !departments.isEmpty();
    }
}

class NoticeBoard {
    ArrayList<Student> students;

    NoticeBoard() {
        students = new ArrayList<>();
    }

    void addStudent(Student student) {
        students.add(student);
    }

    void postNotice(Notice notice) {
        if (!notice.isValid()) {
            System.out.println(
                "Cannot post notice: At least one target department is required."
            );
            return;
        }

        System.out.println(
            "Notice '" + notice.title +
            "' posted to " +
            String.join(", ", notice.departments) + "."
        );

        for (Student student : students) {
            if (notice.departments.contains(student.department)) {
                for (NotificationChannel channel : student.channels) {
                    channel.send(student, notice.title);
                }
            }
        }
    }
}

public class NoticeDemo {
    public static void main(String[] args) {
        Student asha = new Student("Asha", "CSE");
        Student ravi = new Student("Ravi", "ECE");

        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());
        ravi.addChannel(new SmsChannel());

        NoticeBoard board = new NoticeBoard();
        board.addStudent(asha);
        board.addStudent(ravi);

        ArrayList<String> cse = new ArrayList<>();
        cse.add("CSE");

        Notice n1 = new Notice("Lab Closed Tomorrow", cse);
        board.postNotice(n1);

        ArrayList<String> departments = new ArrayList<>();
        departments.add("CSE");
        departments.add("ECE");

        Notice n2 = new Notice("Fee Deadline Extended", departments);
        board.postNotice(n2);

        ArrayList<String> empty = new ArrayList<>();
        Notice n3 = new Notice("Sports Day", empty);
        board.postNotice(n3);
    }
}