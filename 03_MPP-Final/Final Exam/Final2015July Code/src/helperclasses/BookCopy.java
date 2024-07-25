package helperclasses;

public class BookCopy {
	private Book book;
	private int copyNumber;
	private boolean isAvailable;
	public BookCopy(Book book, int copyNumber) {
		this.book = book;
		this.copyNumber = copyNumber;
		isAvailable = true;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getCopyNumber() {
		return copyNumber;
	}
	public void setCopyNumber(int copyNumber) {
		this.copyNumber = copyNumber;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	@Override
	public String toString() {
		return "<isbn: " + book.getIsbn() + " copy num: " + copyNumber + " isAvail: " + isAvailable + ">";
	}
	
}
