package prog4_6_soln.case2;

import java.util.GregorianCalendar;

import prog4_6_soln.case2.Person;
import prog4_6_soln.case2.PersonWithJob;

public class Person {

	private String name;
	private GregorianCalendar dateOfBirth;
	Person(String name, GregorianCalendar dob) {
		this.name = name;
		dateOfBirth = dob;
	}
	public String getName() {
		return name;
	}
	public GregorianCalendar getDateOfBirth() {
		return (GregorianCalendar)dateOfBirth.clone();
	}
	
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Person)) return false;
		Person p = (Person)ob;
		return p.name.equals(name) && p.dateOfBirth.equals(dateOfBirth);
	}
	public int hashCode() {
		int seed = 17;
		int result = 31 * seed + name.hashCode();
		result = 31 * result + dateOfBirth.hashCode();
		return result;
	}
	public static void main(String[] args) {
		System.out.println("Case2: Override in subClass\n");
		Person person1 = new Person("Mo", new GregorianCalendar(2018, 5, 30));
		Person person2 = new Person("Mo", new GregorianCalendar(2018, 5, 30));
		System.out.println("Two Person: "+person1.equals(person2)+"\n");
		
		PersonWithJob pwj1 = new PersonWithJob("MO", new GregorianCalendar(2018, 5, 30), 2500);
		PersonWithJob pwj2 = new PersonWithJob("MO", new GregorianCalendar(2018, 5, 30), 2500);
		System.out.println("Two Person with Job: "+pwj1.equals(pwj2)+"\n");
	}
}
