package helperclasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


final public class CheckoutRecord {
	public CheckoutRecord() {}
	private ArrayList<CheckoutRecordEntry> entries = new ArrayList<>();
	
	public void addEntry(CheckoutRecordEntry c) {
		entries.add(c);
		
	}
	public CheckoutRecord(ArrayList<CheckoutRecordEntry> entries) {
		this.entries = entries;
	}
	
	public String toString() {
		return entries.toString();
	}
	public List<CheckoutRecordEntry> getCheckoutRecordEntries() {
		return Collections.unmodifiableList(entries);
	}
}
