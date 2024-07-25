package Lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class LandlordInfo {
    private List<Building> buildings;

    public LandlordInfo() {
        buildings = new ArrayList<>();
    }

    public void addBuilding(double maintenanceCost) {
        Building building = new Building(maintenanceCost);
        buildings.add(building);
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public double calcProfits() {
        return buildings.stream().mapToDouble(Building::getProfit).sum();
    }
}
