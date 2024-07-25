package business;

import java.time.LocalDate;

final public class LibraryMember extends Person  {
	private String memberId;
	private CheckoutRecord checkoutRecord;

	public LibraryMember(String memberId, String fname, String lname, String tel, Address add,
			CheckoutRecord checkoutRecord) {
		super(fname, lname, tel, add);
		this.memberId = memberId;
		this.checkoutRecord = checkoutRecord;
	}

	public String getMemberId() {
		return memberId;
	}

	public CheckoutRecord getCheckoutRecord() {
		return checkoutRecord;
	}

	public void checkOut(BookCopy bookCopy, LocalDate todayDate, LocalDate dueDate) {
		bookCopy.changeAvailability();
		CheckoutRecordEntry entry = new CheckoutRecordEntry(todayDate, dueDate, bookCopy);
		checkoutRecord.addEntry(entry);
	}

	@Override
	public String toString() {
		return "Member Info: " + "ID: " + memberId + ", name: " + getFirstName() + " " + getLastName() +
				", " + getTelephone() + " " + getAddress();
	}


}
