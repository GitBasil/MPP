package Lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private double maintenanceCost;
    private List<Apartment> apartments;

    public Building(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
        this.apartments = new ArrayList<>();
    }

    public void addApartment(double rent) {
        apartments.add(new Apartment(rent));
    }

    public double getProfit() {
        double totalRent = apartments.stream().mapToDouble(Apartment::getRent).sum();
        return totalRent - maintenanceCost;
    }
}
