package MineTestProb1;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class myHashMapMethod {
	
	//gets all emplo

	public List<String> MySSNList(HashMap<String, Employee> table, List<String> ssnCompair) {
		
		Stream<Employee> employees = table.values().stream();
		
		List<String> ssn = employees
				.map(s->s.getSsn())
				.filter(s-> !ssnCompair.contains(s))
				.sorted()
				.collect(Collectors.toList());		
		return ssn;
	}

	public List<Employee> MyValueInSSNList(HashMap<String, Employee> table, List<String> ssnCompair) {
		
		Stream<Employee> employees = table.values().stream();
		
		List<Employee> emp = employees
				.filter(s->ssnCompair.contains(s.getSsn()))
				.filter(s->s.getSalary()>2000)
				.sorted()
				.collect(Collectors.toList());
		
		return emp;
	}

}
