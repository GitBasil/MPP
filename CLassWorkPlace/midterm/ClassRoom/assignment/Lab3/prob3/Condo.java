package Lab3.prob3;



public class Condo extends Property {
	private Address address;
	private int numberOfFloors;
	public Address getAddress() {
		return address;
	}
	public Condo(Address address, int numberOfFloors) {
		this.address = address;
		this.numberOfFloors = numberOfFloors;
	}

	public double computeRent(){
		return 500 * numberOfFloors;
	}
}
