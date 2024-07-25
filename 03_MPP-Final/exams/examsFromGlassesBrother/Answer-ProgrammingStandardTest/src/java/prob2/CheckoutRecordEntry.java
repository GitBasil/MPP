package prob2;

import java.time.LocalDate;

public class CheckoutRecordEntry {
    private LocalDate checkoutDate;
    private LocalDate dueDate;
    private ItemType itemType;
    private LendingItem lendingItem;
    
    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }
    
    public LocalDate getDueDate() {
        return dueDate;
    }
	
    public ItemType getLendingItemType() {
        return itemType;
    }
    
    public LendingItem getLendingItem() {
        return lendingItem;
    }
    
    public CheckoutRecordEntry(LendingItem item, LocalDate checkoutDate , LocalDate dueDate, ItemType type) {
        lendingItem = item;
        this.checkoutDate = checkoutDate;
        this.dueDate = dueDate;
        this.itemType = type;
    }
    
}
