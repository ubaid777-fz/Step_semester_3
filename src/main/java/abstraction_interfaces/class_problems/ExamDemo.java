import java.util.ArrayList;
abstract class Question {
    int number, marks;
    Question(int number,int marks){this.number=number;this.marks=marks;}
    abstract boolean evaluate(String answer);
}
class MultipleChoiceQuestion extends Question {
    String correctAnswer;
    MultipleChoiceQuestion(int number,int marks,String correctAnswer){super(number,marks);this.correctAnswer=correctAnswer;}
    boolean evaluate(String answer){return answer.equalsIgnoreCase(correctAnswer);}
}
class TrueFalseQuestion extends Question {
    boolean correctAnswer;
    TrueFalseQuestion(int number,int marks,boolean correctAnswer){super(number,marks);this.correctAnswer=correctAnswer;}
    boolean evaluate(String answer){return Boolean.parseBoolean(answer)==correctAnswer;}
}
class Student { String name; Student(String name){this.name=name;} }
class Attempt {
    Student student; ArrayList<Question> questions; ArrayList<String> answers; boolean submitted=false;
    Attempt(Student student,ArrayList<Question> questions){this.student=student;this.questions=questions;answers=new ArrayList<>();}
    void answerQuestion(int questionNumber,String answer){
        if(submitted){System.out.println("Cannot change answers for a submitted examination.");return;}
        while(answers.size()<questions.size()) answers.add("");
        answers.set(questionNumber-1,answer);
        System.out.println("Answer recorded for Question "+questionNumber+".");
    }
    void submit(){
        if(submitted)return;
        submitted=true;
        System.out.println("Exam A submitted by "+student.name+".");
        int total=0,maxMarks=0;
        for(int i=0;i<questions.size();i++){
            Question q=questions.get(i); String answer=answers.get(i); maxMarks+=q.marks;
            if(q.evaluate(answer)){total+=q.marks;System.out.println("Result: Question "+q.number+": Correct ("+q.marks+" points)");}
            else System.out.println("Result: Question "+q.number+": Incorrect (0 points)");
        }
        System.out.println("Total score: "+total+"/"+maxMarks);
    }
}
public class ExamDemo {
    public static void main(String[] args){
        Student student=new Student("Student 1");
        ArrayList<Question> questions=new ArrayList<>();
        questions.add(new MultipleChoiceQuestion(1,5,"C"));
        questions.add(new TrueFalseQuestion(2,5,false));
        Attempt attempt=new Attempt(student,questions);
        System.out.println("Exam A started by Student 1.");
        attempt.answerQuestion(1,"C"); attempt.answerQuestion(2,"True");
        attempt.submit(); attempt.answerQuestion(1,"A");
    }
}