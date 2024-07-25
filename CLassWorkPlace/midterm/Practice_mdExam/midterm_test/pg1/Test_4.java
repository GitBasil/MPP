package Practice_mdExam.midterm_test.pg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class Department {
    final private List<String> employeeIds;
    final String departmentCode;
    public Department(List<String> empIds, String code) {
        employeeIds = new ArrayList<>(empIds);
        departmentCode = code;
    }
    public List<String> getEmployeeIds() {
        return Collections.unmodifiableList(employeeIds);
    }
    public String getDepartmentCode() {
        return departmentCode;
    }
}

public class Test_4 {
    public static void main(String[] args) {
        List<String> empIds = new ArrayList<>();
        empIds.add("E001");
        empIds.add("E002");

        Department department = new Department(empIds, "D001");

        // Attempting to modify the list
        empIds.add("E003");

        // The modification is reflected in the Department instance
        System.out.println(department.getEmployeeIds()); // Output: [E001, E002, E003]
    }
}
