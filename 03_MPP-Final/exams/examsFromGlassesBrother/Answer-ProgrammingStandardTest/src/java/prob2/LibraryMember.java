package prob2;

public class LibraryMember {
    private String memberId;
    private String firstName;
    private String lastName;
    private String phone;
    private CheckoutRecord checkoutRecord;
    
    public LibraryMember(String id, String firstName, String lastName, String phone) {
        memberId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }
    
    public String getMemberId() {
        return memberId;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setCheckoutRecord(CheckoutRecord checkoutRecord) {
        this.checkoutRecord = checkoutRecord;
    }

    public CheckoutRecord getCheckoutRecord() {
        return checkoutRecord;
    }
	
}
