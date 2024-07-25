package Practice_mdExam.Two.studreport;

public class GradeReport {
    private String grade;
    private Student student;

    GradeReport(String grade){
        this.grade = grade;
    }

    void setStudent(Student student) {
        this.student = student;
    }

    public String getGrade() {
        return grade;
    }
    public Student getStudent() {
        return student;
    }
}
