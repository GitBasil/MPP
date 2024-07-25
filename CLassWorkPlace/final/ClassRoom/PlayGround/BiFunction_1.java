package PlayGround;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

class ExamData {
    private String studentName;
    private double testScore;
    
    public ExamData(String name, double score) {
        studentName = name;
        testScore = score;
    }

    public String getStudentName() {
        return studentName;
    }
    public double getTestScore() {
        return testScore;
    }
}

public class BiFunction_1 {

    public static final BiFunction<List<ExamData>, String, List<String>> NAMES_IN_CITY = (list, searchStr) -> 
        list.stream()
        .filter(cust -> cust.getStudentName()
        .startsWith(searchStr))
        .map(cust -> cust.getStudentName())
        .sorted()
        .collect(Collectors.toList());

    public static void main(String[] args) {

        List<ExamData> data = new ArrayList<ExamData>() {
            {
                add(new ExamData("George", 91.3));
                add(new ExamData("Tom", 88.9));
                add(new ExamData("Rick", 80));
                add(new ExamData("Harold", 90.8));
                add(new ExamData("Ignatius", 60.9));
                add(new ExamData("Anna", 77));
                add(new ExamData("Susan", 87.3));
                add(new ExamData("Phil", 99.1));
                add(new ExamData("Alex", 84));
            }
        };

        System.out.println(NAMES_IN_CITY.apply(data, "A"));

    }
}
