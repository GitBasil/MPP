package Practice_mdExam.Two.otherpackages;

import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<DataRecord> h = new ArrayList<>();
    static {
        h.add(new DataRecord("1", "Basil", "A"));
        h.add(new DataRecord("2", "tom", "B"));
        h.add(new DataRecord("3", "Jay", "C"));
        h.add(new DataRecord("4", "Sam", "A"));
    }
}
