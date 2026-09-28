import java.util.ArrayList;
interface NotificationChannel { void send(Student student,String message); }
class EmailChannel implements NotificationChannel { public void send(Student s,String m){System.out.println("[Email → "+s.name+"] "+m);} }
class SmsChannel implements NotificationChannel { public void send(Student s,String m){System.out.println("[SMS → "+s.name+"] "+m);} }
class AppChannel implements NotificationChannel { public void send(Student s,String m){System.out.println("[App → "+s.name+"] "+m);} }
class Student {
    String name,department; ArrayList<NotificationChannel> channels;
    Student(String n,String d){name=n;department=d;channels=new ArrayList<>();}
    void addChannel(NotificationChannel c){channels.add(c);}
}
class Notice {
    String title; ArrayList<String> departments;
    Notice(String t,ArrayList<String> d){title=t;departments=d;}
    boolean isValid(){return title!=null&&!title.isEmpty()&&departments!=null&&!departments.isEmpty();}
}
class NoticeBoard {
    ArrayList<Student> students=new ArrayList<>();
    void addStudent(Student s){students.add(s);}
    void postNotice(Notice notice){
        if(!notice.isValid()){System.out.println("Cannot post notice: At least one target department is required.");return;}
        System.out.println("Notice '"+notice.title+"' posted to "+String.join(", ",notice.departments)+".");
        for(Student s:students)if(notice.departments.contains(s.department))for(NotificationChannel c:s.channels)c.send(s,notice.title);
    }
}
public class NoticeDemo {
    public static void main(String[] args){
        Student asha=new Student("Asha","CSE"),ravi=new Student("Ravi","ECE");
        asha.addChannel(new EmailChannel());asha.addChannel(new AppChannel());ravi.addChannel(new SmsChannel());
        NoticeBoard board=new NoticeBoard();board.addStudent(asha);board.addStudent(ravi);
        ArrayList<String> cse=new ArrayList<>();cse.add("CSE");board.postNotice(new Notice("Lab Closed Tomorrow",cse));
        ArrayList<String> departments=new ArrayList<>();departments.add("CSE");departments.add("ECE");board.postNotice(new Notice("Fee Deadline Extended",departments));
        ArrayList<String> empty=new ArrayList<>();board.postNotice(new Notice("Sports Day",empty));
    }
}