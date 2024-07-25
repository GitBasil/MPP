package helperclasses;

import java.time.LocalDate;

final public class LibraryMember  {
	private String memberId;
	private String firstName;
	private String lastName;
	private String telNumber;
	private Address address;
	private CheckoutRecord record;
	public LibraryMember(String memberId, String fname, String lname, CheckoutRecord record,
			String tel,Address add) {
		
		this.memberId = memberId;
		this.firstName = fname;
		this.lastName = lname;
		this.telNumber = tel;
		this.address = add;
		this.record = record;
	}
	
	//usual way of adding info to the record
	public CheckoutRecord checkout(BookCopy copy, LocalDate checkoutDate, LocalDate dueDate) throws LibrarySystemException {
		if(!copy.isAvailable()) throw new LibrarySystemException("Copy of " + copy.getBook().getTitle() + " is not available.");
		copy.setAvailable(false);
		CheckoutRecordEntry entry = CheckoutRecordEntry.createEntry(copy, checkoutDate, dueDate);
		record.addEntry(entry);
		return record;
	}
	//not the usual way of adding info to the record -- no save to data storage
	public void addCheckoutEntry(CheckoutRecordEntry entry) {
		record.addEntry(entry);
	}
	
	public String getMemberId() {
		return memberId;
	}

	public CheckoutRecord getRecord() {
		return record;
	}
	
	public String formattedCheckoutRecord() {
		StringBuilder sb = new StringBuilder();
		for(CheckoutRecordEntry e : record.getCheckoutRecordEntries()) {
			sb.append(e.toString() + "\n");
		}
		return sb.toString();
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof LibraryMember)) return false;
		LibraryMember mem = (LibraryMember)ob;
		return mem.memberId.equals(memberId);
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public Address getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		return memberId + ":" + getFirstName() + " " + getLastName();
				
	}

	
}
