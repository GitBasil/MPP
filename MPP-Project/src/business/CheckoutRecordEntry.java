package business;

import java.io.Serializable;
import java.time.LocalDate;

final public class CheckoutRecordEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private BookCopy bookCopy;


    public CheckoutRecordEntry(LocalDate checkoutDate, LocalDate dueDate, BookCopy bookCopy) {
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.bookCopy = bookCopy;
    }


    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public boolean isOverdue() {
        return LocalDate.now().isAfter(dueDate);
    }

    @Override
    public String toString() {
        return String.format("%-20s %-15s %-15s", bookCopy.getBook().getTitle(), checkoutDate, dueDate);
    }
}
