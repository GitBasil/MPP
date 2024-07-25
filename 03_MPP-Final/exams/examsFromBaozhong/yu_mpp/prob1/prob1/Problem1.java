package prob1.prob1;

import prob1.helperclasses.*;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
public class Problem1 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Problem1 p = new Problem1();
		List<LibraryMember> members = TestData.INSTANCE.getMembers();
		p.books = TestData.INSTANCE.getAllBooks().iterator();
		Problem1 p1 =  new Problem1();
		LibraryMember member = p1.detectIfWinnerDuringCheckout(members);
		
	}
	Iterator<Book> books;
	
	public  LibraryMember detectIfWinnerDuringCheckout(List<LibraryMember> mems) {
		//return null;
		//fix this
		return mems.stream().filter(mem -> doCheckout(mem)
				.getCheckoutRecordEntries().size() == 10)
				.findFirst().orElse(null);
	}

	public CheckoutRecord doCheckout(LibraryMember mem){
			try {
				return mem.checkout(books.next().getNextAvailableCopy(), LocalDate.now(), LocalDate.of(2015, 9, 1));
			}catch (LibrarySystemException e){
				throw new RuntimeException(e);
			}
		}
	}

