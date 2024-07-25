package Practice_mdExam.Two.studreport;

public class Student {
    private String name;
    private GradeReport gradeReport;
    
    Student(String name){
        this.name = name;
    }

    void setGradeReport(GradeReport grade){
        this.gradeReport = grade;
    }

    public String getName() {
        return name;
    }
    public GradeReport getGradeReport() {
        return gradeReport;
    }
}
