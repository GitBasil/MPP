package QuizAssignment.Quiz3;

public class Customer {
    private int id; 
    private String name; 
    private String city;

    Customer(int id, String name, String city)
    {
        this.id = id;
        this.name = name;
        this.city = city;
    }
    
    
    public String getCity() {
        return city;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
