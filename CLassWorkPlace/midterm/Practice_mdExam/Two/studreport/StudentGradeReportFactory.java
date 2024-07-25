package Practice_mdExam.Two.studreport;

public class StudentGradeReportFactory {
    public static StudentAndGrade createGradeStudentReport(String name, String grade) {
        Student student = new Student(name);
        GradeReport gradeReport = new GradeReport(grade);
        student.setGradeReport(gradeReport);
        gradeReport.setStudent(student);

        StudentAndGrade studentAndGrade = new StudentAndReportImpl(student,gradeReport);

        return studentAndGrade;
    }
}
