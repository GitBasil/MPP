package two.prob3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuarterlyReport {
	private HashMap<QuarterlySalary, List<Employee>> map = new HashMap<>();
	public void addEntry(QuarterlySalary qs, Employee emp) {
		if(map.get(qs) == null) {
			map.put(qs, new ArrayList<Employee>());
		}
		List<Employee> emps = map.get(qs);
		emps.add(emp);
	}
	public List<Employee> lookup(QuarterlySalary qs) {
		return map.get(qs);
	}
}
