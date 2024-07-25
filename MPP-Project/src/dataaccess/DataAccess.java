package dataaccess;

import business.Book;
import business.LibraryMember;
import java.util.HashMap;

public interface DataAccess { 
	public HashMap<String,Book> readBooksMap();
	public HashMap<String,User> readUserMap();
	public HashMap<String, LibraryMember> readMemberMap();
	// public HashMap<String, CheckoutRecord> readCheckoutRecordsMap();
	// public HashMap<String, CheckoutRecordEntry> readCheckoutRecordEntriesMap();
	public void saveBook(Book book); 
	public void saveNewMember(LibraryMember member); 
	public LibraryMember searchMember(String memberId); 
	public Book searchBook(String isbn); 
	public void saveNewBook(Book book); 
}
