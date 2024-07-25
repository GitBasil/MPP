package Customer;

public class Main {

	public static void main(String[] args) {
		/**
		 * Address(String str, String cit, String st, String z)
		 **/
		Address addBill_1 = new Address("10 Adams", "Chicago", "CH", "52556");
		Address addShip_1 = new Address("110 Burlington", "Fairfield", "IA", "52556");
		Address addBill_2 = new Address("322 Adams", "Fairfield", "AI", "54321");
		Address addShip_2 = new Address("2210 Burlington", "Fairfield", "IA", "52556");
		
		Customer c1 = new Customer("Mohammed", "ALDini","282112705476");
		c1.setBillingAddress(addBill_1);
		c1.setShippingAddress(addShip_1);
		
		Customer c2 = new Customer();
		c2.setBillingAddress(addBill_2);
		c2.setShippingAddress(addShip_2);
		
		//Creates an Employee array of length 2
		Customer[] customerArray = new Customer[2];
		customerArray[0] = c1;
		customerArray[1] = c2;
		
		/*
		 * Then loop through the array and print to the console all those Customers whose billingAddress 
		 * is located in the city of Chicago (when you create instances of Customer initially, 
		 * be sure to create at least one Customer whose billing address is in Chicago).
		 */
		for(int i = 0; i < customerArray.length; ++i) {
			String cityName = customerArray[i].getBillingAddress().getCity();
			if(cityName.equals("Chicago")) {
				System.out.println("Found the Customer whose billingAddress is located in the city of Chicago:" + customerArray[i].toString());
			}
		}
		
		
	}

}
