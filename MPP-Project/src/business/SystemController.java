package business;

import dataaccess.Auth;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import dataaccess.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SystemController implements ControllerInterface {
	public static Auth currentAuth = null;
	
	public void login(String id, String password) throws LoginException {
		DataAccess da = new DataAccessFacade();
		HashMap<String, User> map = da.readUserMap();
		if(!map.containsKey(id)) {
			throw new LoginException("ID " + id + " not found");
		}
		String passwordFound = map.get(id).getPassword();
		if(!passwordFound.equals(password)) {
			throw new LoginException("Password incorrect");
		}
		currentAuth = map.get(id).getAuthorization();
		
	}
	@Override
	public List<String> allMemberIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readMemberMap().keySet());
		return retval;
	}

	@Override
	public boolean checkAddMemberAuth(){
		if(currentAuth == Auth.BOTH || currentAuth == Auth.LIBRARIAN){
			System.out.println("Access Auth");
			return true;
		}
		else return false;
	}

	@Override
	public boolean checkAddBookAuth(){
		System.out.println("Authentication type is: "+currentAuth);
		if(currentAuth == Auth.BOTH || currentAuth == Auth.ADMIN){
			System.out.println("Access Bool Auth");
			return true;
		}
		else return false;
	}
	
	@Override
	public List<String> allBookIds() {
		DataAccess da = new DataAccessFacade();
		List<String> retval = new ArrayList<>();
		retval.addAll(da.readBooksMap().keySet());
		return retval;
	}
	
	public List<LibraryMember> getCheckoutEntriesByISBN(String isbn) {
		DataAccess da = new DataAccessFacade();
		HashMap<String, LibraryMember> mems = da.readMemberMap();
		List<LibraryMember> lmem = new ArrayList<>();
		for (LibraryMember itm : mems.values()) {
			boolean has = false;
			for (CheckoutRecordEntry ce : itm.getCheckoutRecord().getEntries()) {
				if(ce.getBookCopy().getBook().getIsbn().equals(isbn))
					{
						has = true;
					}
			}
			if(has) lmem.add(itm);
		}
		return lmem;
	}

	public void addNewMember(LibraryMember member){
		DataAccess da = new DataAccessFacade();
		da.saveNewMember(member);
	}
	
	public void addNewBook(Book book){
		DataAccess da = new DataAccessFacade();
		da.saveNewBook(book);
	}

	@Override
	public LibraryMember searchMember(String id) {
		DataAccess da = new DataAccessFacade();
		return da.searchMember(id);

	}
	
}
