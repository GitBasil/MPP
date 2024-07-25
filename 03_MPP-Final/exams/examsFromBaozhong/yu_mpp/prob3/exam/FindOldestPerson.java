package prob3.exam;

import java.util.List;

//DO NOT MODIFY METHOD SIGNATURE OR STATIC QUALIFIER
public class FindOldestPerson {
	public static Person findOldestPerson(List<Person> persons) {
		//implement
		return persons.stream().reduce(persons.get(0),(p1, p2) -> p1.getAge()>p2.getAge()?p1:p2 );
				                        
	}
	
	
}
