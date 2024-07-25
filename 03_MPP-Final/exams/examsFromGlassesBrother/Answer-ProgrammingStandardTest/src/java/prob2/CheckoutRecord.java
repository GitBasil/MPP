package prob2;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord {
    private List<CheckoutRecordEntry> checkoutRecordEntries;

    
    public List<CheckoutRecordEntry> getCheckoutEntryList() {
        return checkoutRecordEntries;
    }
    
    public void addCheckoutEntry(CheckoutRecordEntry recordEntry) {
        if(getCheckoutEntryList() == null) {
            this.checkoutRecordEntries = new ArrayList<CheckoutRecordEntry>();
        }
        checkoutRecordEntries.add(recordEntry);
    }
	
}
