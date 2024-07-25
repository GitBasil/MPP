package prob2;

public class CD extends LendingItem{
    private String productId;
    private String title;
    private String company;
    
    public CD(String productId, String title, String company) {
        this.productId = productId;
        this.title = title;
        this.company = company;
    }
	
    @Override
    public boolean equals(Object o) {
        if(o instanceof CD) {
            CD cd = (CD) o;
            return productId.equals(cd.productId);
        }
        return false;
    }
}
