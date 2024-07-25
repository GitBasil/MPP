package prob2.exam.partB;
import java.util.*;
public class CheckoutRecord {
	private List<CheckoutRecordEntry> checkoutEntries = new ArrayList<>();
	public List<CheckoutRecordEntry> getCheckoutEntries() {
		return checkoutEntries;
	}
	public CheckoutRecord() {//not possible to construct by passing in list}
	}
	public void addEntry(CheckoutRecordEntry entry) {
		checkoutEntries.add(entry);
	}
	
	@Override
	public String toString() {
		return checkoutEntries.toString();
	}
}
