package Lab3.prob1;

// Before changing the classes the issue with true and false was hapenning because of LSP
// A person shouldn't equal a person with a job even if they have the same name

public class Main {
    public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");
		//As PersonsWithJobs, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}
}
