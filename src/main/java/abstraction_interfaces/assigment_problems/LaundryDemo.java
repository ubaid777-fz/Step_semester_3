interface WashType {
    int getDuration(); double getCharge(); String getName();
}
class QuickWash implements WashType {
    public int getDuration(){return 30;} public double getCharge(){return 20;} public String getName(){return "Quick";}
}
class NormalWash implements WashType {
    public int getDuration(){return 45;} public double getCharge(){return 30;} public String getName(){return "Normal";}
}
class HeavyWash implements WashType {
    public int getDuration(){return 60;} public double getCharge(){return 45;} public String getName(){return "Heavy";}
}
class Student { String name; Student(String n){name=n;} }
class WashCycle {
    Student student; WashingMachine machine; WashType washType;
    WashCycle(Student s,WashingMachine m,WashType w){student=s;machine=m;washType=w;}
}
class WashingMachine {
    private boolean busy; String machineId;
    WashingMachine(String id){machineId=id;busy=false;}
    void startWash(Student student,WashType washType){
        if(busy){System.out.println("Machine "+machineId+" is currently busy.");return;}
        busy=true;
        System.out.println(washType.getName()+" wash started on "+machineId+" for "+student.name+" ("+washType.getDuration()+" min).");
        System.out.printf("Charge: ₹%.2f%n",washType.getCharge());
    }
    void completeWash(){if(busy){busy=false;System.out.println(machineId+" cycle completed.");System.out.println(machineId+" is now free.");}}
}
public class LaundryDemo {
    public static void main(String[] args){
        Student asha=new Student("Asha"),ravi=new Student("Ravi"),neha=new Student("Neha");
        WashingMachine m1=new WashingMachine("M1"),m2=new WashingMachine("M2");
        m1.startWash(asha,new QuickWash());m1.startWash(ravi,new HeavyWash());
        m2.startWash(ravi,new HeavyWash());m1.completeWash();m1.startWash(neha,new NormalWash());
    }
}