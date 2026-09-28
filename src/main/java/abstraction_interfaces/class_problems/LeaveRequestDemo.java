abstract class Employee {
    String name; Employee(String name){this.name=name;}
    abstract boolean canTakeLeave(int days);
}
class FullTimeEmployee extends Employee { FullTimeEmployee(String n){super(n);} boolean canTakeLeave(int d){return d<=20;} }
class PartTimeEmployee extends Employee { PartTimeEmployee(String n){super(n);} boolean canTakeLeave(int d){return d<=10;} }
class Contractor extends Employee { Contractor(String n){super(n);} boolean canTakeLeave(int d){return d<=5;} }
class LeaveRequest {
    Employee employee; String startDate,endDate; private String status;
    LeaveRequest(Employee e,String s,String end,int days){
        employee=e;startDate=s;endDate=end;
        if(e.canTakeLeave(days)){status="Pending";System.out.println("Leave request submitted for "+e.name+" ("+s+"-"+end+"). Status: Pending.");}
        else{status="Rejected";System.out.println("Leave request rejected for "+e.name);}
    }
    void approve(){if(status.equals("Pending")){status="Approved";System.out.println(employee.name+"'s leave request ("+startDate+"-"+endDate+") approved. Status: Approved.");}}
    void reject(){if(status.equals("Pending")){status="Rejected";System.out.println(employee.name+"'s leave request ("+startDate+"-"+endDate+") rejected. Status: Rejected.");}}
    void changeToPending(){if(!status.equals("Pending"))System.out.println("Cannot change leave request status from "+status+" to Pending.");}
}
public class LeaveRequestDemo {
    public static void main(String[] args){
        Employee john=new FullTimeEmployee("John"),jane=new PartTimeEmployee("Jane");
        LeaveRequest request1=new LeaveRequest(john,"Jan 1","Jan 5",5);request1.approve();
        LeaveRequest request2=new LeaveRequest(jane,"Feb 10","Feb 11",2);request2.reject();
        request1.changeToPending();
    }
}