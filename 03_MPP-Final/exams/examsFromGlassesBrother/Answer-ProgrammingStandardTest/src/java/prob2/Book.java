package prob2;

public class Book extends LendingItem{
    private String isbn;
    private String title;
    private String authorFirstName;
    private String authorLastName;
	
    public Book(String isbn, String title, String authorFirstName, String authorLastName) {
        this.isbn= isbn;
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o instanceof Book) {
            Book book = (Book) o;
            return isbn.equals(book.isbn);
        }
        return false;
    }
}
