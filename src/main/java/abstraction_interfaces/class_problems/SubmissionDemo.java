import java.time.LocalDate;

abstract class Assignment {
    String title;
    int maxMarks;
    LocalDate dueDate;

    Assignment(String title, int maxMarks, LocalDate dueDate) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDate = dueDate;
    }

    abstract double applyPenalty(double marks, long lateDays);
}

class CodingAssignment extends Assignment {
    CodingAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    double applyPenalty(double marks, long lateDays) {
        double penalty = lateDays * 0.10;
        return marks * (1 - penalty);
    }
}

class WrittenAssignment extends Assignment {
    WrittenAssignment(String title, int maxMarks, LocalDate dueDate) {
        super(title, maxMarks, dueDate);
    }

    double applyPenalty(double marks, long lateDays) {
        double penalty = lateDays * 0.20;
        return marks * (1 - penalty);
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class Submission {
    Student student;
    Assignment assignment;
    LocalDate submissionDate;
    private String status;
    private double finalMarks;

    Submission(Student student, Assignment assignment, LocalDate submissionDate) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDate = submissionDate;
        this.status = "Submitted";
    }

    void grade(double marks) {
        if (!status.equals("Submitted")) {
            System.out.println("Cannot grade this submission.");
            return;
        }

        long lateDays = 0;

        if (submissionDate.isAfter(assignment.dueDate)) {
            lateDays = java.time.temporal.ChronoUnit.DAYS.between(
                    assignment.dueDate, submissionDate
            );
        }

        finalMarks = assignment.applyPenalty(marks, lateDays);
        status = "Graded";

        System.out.printf("%s graded: %.0f/%d. Status: Graded.%n",
                student.name, finalMarks, assignment.maxMarks);
    }

    void resubmit() {
        if (status.equals("Graded")) {
            System.out.println("Cannot resubmit: '" +
                    assignment.title + "' has already been graded.");
        } else {
            System.out.println("Resubmission allowed.");
        }
    }
}

public class SubmissionDemo {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");

        Assignment coding = new CodingAssignment(
                "Linked List Lab", 50, LocalDate.of(2026, 3, 10)
        );

        Assignment written = new WrittenAssignment(
                "Design Essay", 50, LocalDate.of(2026, 3, 12)
        );

        Submission s1 = new Submission(
                asha, coding, LocalDate.of(2026, 3, 10)
        );

        Submission s2 = new Submission(
                ravi, written, LocalDate.of(2026, 3, 14)
        );

        System.out.println("Asha's submission for 'Linked List Lab' received (on time). Status: Submitted.");
        System.out.println("Ravi's submission for 'Design Essay' received (2 days late). Status: Submitted.");

        s1.grade(45);
        s2.grade(40);
        s1.resubmit();
    }
}