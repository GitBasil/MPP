package Lab3.prob2;

import java.util.*;

public class Main {

public static void main(String[] args) {
	LandlordInfo landlord = new LandlordInfo();	
	landlord.addBuilding(150);
	landlord.addBuilding(175);
	landlord.addBuilding(150);
	landlord.addBuilding(175);
	
	List<Building> buildings = landlord.getBuildings();
	buildings.get(0).addApartment(600);
	buildings.get(0).addApartment(700);
	
	buildings.get(1).addApartment(500);
	buildings.get(1).addApartment(450);
	
	buildings.get(2).addApartment(1100);
	buildings.get(2).addApartment(650);
	
	buildings.get(3).addApartment(400);
	buildings.get(3).addApartment(900);

	System.out.println(landlord.calcProfits());
			
	}

}