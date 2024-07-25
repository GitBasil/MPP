package Practice_mdExam.Two;

import java.util.*;

import Practice_mdExam.Two.otherpackages.DataRecord;
import Practice_mdExam.Two.otherpackages.Database;
import Practice_mdExam.Two.studreport.StudentAndGrade;
import Practice_mdExam.Two.studreport.StudentGradeReportFactory;



public class Main {

    public static void main(String[] args) {
        List<DataRecord> records = Database.h;
        List<StudentAndGrade> grades = new ArrayList<>();
        for (DataRecord dataRecord : records) {
            StudentAndGrade studentAndGrade = StudentGradeReportFactory.createGradeStudentReport(dataRecord.getName(), dataRecord.getGrade());
            grades.add(studentAndGrade);
        }

        for (StudentAndGrade studentAndGrade : grades) {
            System.out.println(studentAndGrade.getGradeReport().getGrade());
        }
    }
    
}
