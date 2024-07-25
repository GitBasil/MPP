package Practice_mdExam.Two.studreport;

public class StudentAndReportImpl implements StudentAndGrade {
    private Student student;
    private GradeReport gradeReport;

    public StudentAndReportImpl(Student student, GradeReport gradeReport) {
        this.student = student;
        this.gradeReport = gradeReport;
    }

    @Override
    public Student getStudent() {
        return student;
    }

    @Override
    public GradeReport getGradeReport() {
        return gradeReport;
    }
    
}
