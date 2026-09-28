abstract class Employee {
    String name;

    Employee(String name) {
        this.name = name;
    }

    abstract boolean canTakeLeave(int days);
}

class FullTimeEmployee extends Employee {
    FullTimeEmployee(String name) { super(name); }
    boolean canTakeLeave(int days) { return days <= 20; }
}

class PartTimeEmployee extends Employee {
    PartTimeEmployee(String name) { super(name); }
    boolean canTakeLeave(int days) { return days <= 10; }
}

class Contractor extends Employee {
    Contractor(String name) { super(name); }
    boolean canTakeLeave(int days) { return days <= 5; }
}

class LeaveRequest {
    Employee employee;
    String startDate;
    String endDate;
    private String status;

    LeaveRequest(Employee employee, String startDate,
                 String endDate, int days) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;

        if (employee.canTakeLeave(days)) {
            status = "Pending";
            System.out.println(
                    "Leave request submitted for " + employee.name
                    + " (" + startDate + "-" + endDate + "). Status: Pending."
            );
        } else {
            status = "Rejected";
            System.out.println("Leave request rejected for " + employee.name);
        }
    }

    void approve() {
        if (status.equals("Pending")) {
            status = "Approved";
            System.out.println(
                    employee.name + "'s leave request ("
                    + startDate + "-" + endDate
                    + ") approved. Status: Approved."
            );
        }
    }

    void reject() {
        if (status.equals("Pending")) {
            status = "Rejected";
            System.out.println(
                    employee.name + "'s leave request ("
                    + startDate + "-" + endDate
                    + ") rejected. Status: Rejected."
            );
        }
    }

    void changeToPending() {
        if (!status.equals("Pending")) {
            System.out.println(
                    "Cannot change leave request status from "
                    + status + " to Pending."
            );
        }
    }
}

public class LeaveRequestDemo {
    public static void main(String[] args) {
        Employee john = new FullTimeEmployee("John");
        Employee jane = new PartTimeEmployee("Jane");

        LeaveRequest request1 = new LeaveRequest(
                john, "Jan 1", "Jan 5", 5
        );

        request1.approve();

        LeaveRequest request2 = new LeaveRequest(
                jane, "Feb 10", "Feb 11", 2
        );

        request2.reject();

        request1.changeToPending();
    }
}