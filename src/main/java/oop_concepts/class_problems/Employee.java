public class Employee {
    String empId; double salary;
    public Employee(String empId, double salary) { this.empId = empId; this.salary = salary; }
    public void raiseSalary(double salary) { this.salary += salary; }
    public static void main(String[] args) { Employee[] team = {new Employee("E-101", 40000), new Employee("E-102", 55000), new Employee("E-103", 62000), new Employee("E-104", 48000)}; for (Employee emp : team) { emp.raiseSalary(5000); System.out.println(emp.empId + " | Final Salary: Rs " + emp.salary); } }
}