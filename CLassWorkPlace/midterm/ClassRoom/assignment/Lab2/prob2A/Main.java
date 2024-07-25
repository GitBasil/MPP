package prob2A;

public class Main {
    public static void main(String[] args){
        Student std = new Student("Basil Abubaker");
        System.out.println(std.getName());
        System.out.println(std.getGradeReport().getStudent().getName());
    }

}

class Student {
    private String name;
    private GradeReport gradeReport;
    public Student(String name){
        this.name = name;
        this.gradeReport = new GradeReport(this);
    }

    public String getName(){
        return this.name;
    }

    public GradeReport getGradeReport(){
        return gradeReport;
    }
}

class GradeReport {
    private Student student;
    public GradeReport(Student student){
        this.student = student;
    }

    public Student getStudent(){
        return student;
    }
}