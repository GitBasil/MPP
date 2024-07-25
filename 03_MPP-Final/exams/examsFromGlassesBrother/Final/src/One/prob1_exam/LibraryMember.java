package One.prob1_exam;

import java.time.LocalDate;

public class LibraryMember {
	private String memberId;
	private String firstName;
	private String lastName;
	private CheckoutRecord record;
	private Address address;
	public LibraryMember(String id, String fName, String lName, CheckoutRecord rec, Address add) {
		this.memberId = id;
		this.firstName = fName;
		this.lastName = lName;
		this.record = rec;
		this.address = add;
	}
	
	public void checkoutBook(Book book, LocalDate checkoutDate, LocalDate dueDate) {
		BookCopy copy = book.getNextAvailableCopy();
		if(copy == null) {
			System.out.println("No copy available");
		} else {
			copy.setAvailable(false);
			CheckoutRecordEntry entry = new CheckoutRecordEntry(copy, checkoutDate, dueDate);
			record.addEntry(entry);	
		}
		
	}
	
	public void returnBook(BookCopy copy) {
		copy.setAvailable(true);
		
	}

	public String getMemberId() {
		return memberId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public CheckoutRecord getRecord() {
		return record;
	}

	public Address getAddress() {
		return address;
	}
	
}
