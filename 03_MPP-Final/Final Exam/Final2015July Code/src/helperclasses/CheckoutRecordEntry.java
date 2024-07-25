package helperclasses;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;


/* Immutable */
final public class CheckoutRecordEntry {
	private static final Logger LOG = Logger.getLogger(CheckoutRecordEntry.class.getName());
	private BookCopy copy;
	private LocalDate checkoutDate;
	private LocalDate dueDate;
	
	//this field is necessary in order to detect which items are overdue
	private boolean hasBeenReturned = false;
	public CheckoutRecordEntry(BookCopy copy, LocalDate checkoutDate, LocalDate dueDate) { 
		this.copy = copy;
		this.checkoutDate = checkoutDate;
		this.dueDate = dueDate;
	}
	/** factory  method */
	public static CheckoutRecordEntry createEntry(BookCopy copy,
			LocalDate checkoutDate, LocalDate dueDate) {
		return new CheckoutRecordEntry(copy, checkoutDate, dueDate);
	}
	public BookCopy getCopy() {
		return copy;
	}
	public LocalDate getCheckoutDate() {
		return checkoutDate;
	}
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	/** convenience method that determines if this copy is overdue */
	public boolean isOverdue() {
		if(hasBeenReturned) return false;
		if(dueDate.isBefore(LocalDate.now())) return true;
		return false;
	}
	
	
	@Override
	public String toString() {
		return "[" + "checkoutdate:" + 
	        checkoutDate.format(DateTimeFormatter.ofPattern(Util.DATE_PATTERN)) +
	        ", dueDate: " + dueDate.format(DateTimeFormatter.ofPattern(Util.DATE_PATTERN)) +
	        ", book: " + copy + "]";
	}
}
