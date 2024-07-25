package Practice_mdExam.Two.otherpackages;

public class DataRecord {
    String id;
	String name;
	String grade;

    DataRecord(String id, String name, String grade){
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
