package helperclasses;
import java.util.*;
public class Book {
	private String isbn;
	private int maxCheckoutLength;
	private String title;
	private List<BookCopy> copies = new ArrayList<>();
	public Book(String isbn, String title, int numCopies, int maxCheckout) {
		this.isbn = isbn;
		this.title = title;
		this.maxCheckoutLength = maxCheckout;
		for(int i = 0; i < numCopies; ++i) {
			addCopy();
		}
	}
	public BookCopy getNextAvailableCopy() {
		for(BookCopy copy : copies) {
			if(copy.isAvailable()) {
				return copy;
			}
		}
		return null;
	}
	public void addCopy() {
		copies.add(new BookCopy(this, copies.size() + 1));
	}
	public int getMaxCheckoutLength() {
		return maxCheckoutLength;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public List<BookCopy> getCopies() {
		return copies;
	}
	public String getTitle() {
		return title;
	}
}
