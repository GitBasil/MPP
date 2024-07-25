package two.prob1;

import java.util.ArrayList;
import java.util.List;

final public class LibraryMember {
	private String firstName;
	private String lastName;
	private int age;
	private Address address;
	private List<BookCopy> checkedOutCopies = new ArrayList<BookCopy>();

	public LibraryMember(String fname, String lname, int age, Address add) {

		this.firstName = fname;
		this.lastName = lname;
		this.age = age;
		this.address = add;
	}

	public void addBookCopyToMember(BookCopy bc) {
		checkedOutCopies.add(bc);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public Address getAddress() {
		return address;
	}

	public List<BookCopy> getCheckedOutCopies() {
		return checkedOutCopies;
	}
	
	public String getFullname() {
		return firstName + " " + lastName;
	}

	public String toString() {
		return firstName + " " + lastName + " " + age + "yrs old" + ": " + address.getState();
	}
}
