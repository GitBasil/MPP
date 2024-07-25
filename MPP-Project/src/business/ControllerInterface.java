package business;

import java.util.List;

public interface ControllerInterface {
	public void login(String id, String password) throws LoginException;
	public List<String> allMemberIds();
	public LibraryMember searchMember(String id);
	public List<String> allBookIds();
	public void addNewMember(LibraryMember member);
	public void addNewBook(Book book);
	public boolean checkAddMemberAuth();
	public boolean checkAddBookAuth();
}
