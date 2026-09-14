import java.util.*;

public class StudentRecordParser {
    static void parseStudentRecord(String csvLine) { String[] fields = csvLine.split(","); if (fields.length != 3) { System.out.println("Invalid Record"); return; } String name = fields[0].trim(), rollNumber = fields[1].trim(), department = fields[2].trim(); System.out.println("Name: " + name + " | Roll No: " + rollNumber + " | Dept: " + department); }
    public static void main(String[] args) { Scanner sc = new Scanner(System.in); System.out.print("Enter student record: "); String csvLine = sc.nextLine(); parseStudentRecord(csvLine); sc.close(); }
}