package PlayGround;

import java.util.*;
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

public class Statistics {

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


        // DoubleSummaryStatistics summary = data.stream().collect(Collectors.summarizingDouble(p -> p.getTestScore()));
        DoubleSummaryStatistics summary = data.stream().collect(Collectors.summarizingDouble(ExamData::getTestScore));

        double averageTestScore = summary.getAverage();
        double maxTestScore = summary.getMax();

        System.out.println("Average Test Score: " + averageTestScore);
        System.out.println("Max Test Score: " + maxTestScore);
    }
}
