package Practice_mdExam.prepratice.company;

import java.util.*;

public class Department {
    private String name;
    private String location;
    private List<Position> positions;
    
    public Department(String name, String location){
        this.name = name;
        this.location = location;

        this.positions = new ArrayList<>();
    }

    public double getSalary()
    {
        double salary=0;
        for (Position position : positions) {
            salary += position.getSalary();
        }
        return salary;
    }

    public void addPosition(Position position)
    {
        this.positions.add(position);
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<Position> getPositions() {
        return positions;
    }
}
