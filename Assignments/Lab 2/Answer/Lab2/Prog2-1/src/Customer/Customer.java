/**
 * 
 */
package Customer;

/**
 * @author Mohammed AlDIni
 *
 */
public class Customer {
	static final String IMPORTANT_FIRST = "Joe";
	static final String IMPORTANT_LAST =  "Smith";
	static final String IMPORTANT_SNN =  "332-221-4444";
	private String firstName; 
	private String lastName;
	private String socSecurityNum;
	private Address billingAddress;
	private Address shippingAddress;
	
	public Customer(String fName, String lName,String snn) {
		firstName = fName;
		lastName = lName;
		socSecurityNum = snn;
	}
	
	/** 
	 *  Default constructor creates instance of "Maldini" 
	 *  Customer
	 */
	public Customer() {
		this(IMPORTANT_FIRST, IMPORTANT_LAST, IMPORTANT_SNN);
	}
	
	/** 
	 * Provides a string representation of this Customer
	 **/
	public String toString() {
		return "[" + firstName + ", " + lastName + ", ssn:" + socSecurityNum +"]";
	}
	
	/**
	 * Getter AND Setter
	 * */
	
	public Address getBillingAddress() {
		return billingAddress;
	}
	
	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public Address getShippingAddress() {
		return shippingAddress;
	}
	
	public void setShippingAddress(Address shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getFisrtName() {
		return firstName;
	}
	
	public void setFisrtName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	
	public void settLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSNN() {
		return socSecurityNum;
	}
	
	public void setSNN(String socSecurityNum) {
		this.socSecurityNum = socSecurityNum;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
