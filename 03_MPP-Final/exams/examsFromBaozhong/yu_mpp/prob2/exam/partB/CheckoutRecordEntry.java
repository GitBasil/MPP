package prob2.exam.partB;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CheckoutRecordEntry {
	private BookCopy copy;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	
	public CheckoutRecordEntry(BookCopy copy, LocalDate checkoutDate, LocalDate dueDate) { 
		this.copy = copy;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
	public BookCopy getCopy() {
		return copy;
	}
	public void setCopy(BookCopy copy) {
		this.copy = copy;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(LocalDate checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	@Override
	public String toString() {
		String pattern = "MM/dd/yyyy";
		return "[" + copy + " checkout date: " + checkoutDate.format(DateTimeFormatter.ofPattern(pattern))
				  + " due date: " + dueDate.format(DateTimeFormatter.ofPattern(pattern)) + "]";
	}
	
}
