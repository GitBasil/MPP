package business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final public class CheckoutRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<CheckoutRecordEntry> entries;

    public CheckoutRecord() {
        entries = new ArrayList<>();
    }


    public void addEntry(CheckoutRecordEntry entry) {
        entries.add(entry);
    }

    public List<CheckoutRecordEntry> getEntries() {
        return Collections.unmodifiableList(entries);
    }

    @Override
    public String toString() {
        return "CheckoutRecord [entries=" + entries + "]";
    }
}
