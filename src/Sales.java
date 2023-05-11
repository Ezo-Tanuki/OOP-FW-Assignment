package src;
public class Sales {

    // each object contains details of one sale
    
    private String itemId;     // id of the item
    
    private double value;      // the price of one item
    
    private int quantity;      // the number of the items sold
    
    // constructor missing
    public Sales(String itemId, double value, int quantity){
        this.itemId = itemId;
        this.value = value;
        this.quantity = quantity;
    }
    public String getiItemId() {return this.itemId;}
    
    public double getValue() {return this.value;}
    
    public int getQuantity() {return this.quantity;}

    //extra
    public double totalRevenue() {return this.getValue() * this.getQuantity();}
    }