import java.util.*;

class EmployeePay {
    String name, type;
    int pay;
    EmployeePay(String name, String type, int pay) { this.name = name; this.type = type; this.pay = pay; }
    public String toString() { return "Payslip[name=" + name + ", type=" + type + ", pay=" + pay + "]"; }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<EmployeePay> employees = new ArrayList<>();
        int total = 0, highest = -1;
        String topEarner = "";

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split(" ");
            String type = p[0], name = p[1];
            int pay;
            if (type.equals("FullTime")) pay = Integer.parseInt(p[2]);
            else if (type.equals("PartTime")) pay = Integer.parseInt(p[2]) * Integer.parseInt(p[3]);
            else pay = Integer.parseInt(p[2]);

            EmployeePay employee = new EmployeePay(name, type, pay);
            employees.add(employee);
            total += pay;
            if (pay > highest) { highest = pay; topEarner = name; }
        }

        for (EmployeePay employee : employees) System.out.println(employee);
        System.out.println("Total " + total);
        System.out.println("top earner " + topEarner);
    }
}