package src;
public class SalesPerson {

    // each object contains details of one salesperson

    private String id;

    private Sales[] salesHistory; // details of the different sales

    private int count = 0; // number of sales made



    //constructor for a new salesperson

    public SalesPerson(String id){

    // code missing
    // init size 100
        this.salesHistory = new Sales[100];
        this.id = id;

    }

    // constructor for a salesperson transferred (together with their sales details) from another branch

    public SalesPerson(String id, Sales[] s, int c){

        // code missing
        this.id = id;
        this.salesHistory = s;
        this.count = c;
        
    
        }

    public int getCount() {return this.count;}

    public String getId() {return this.id;}

    public Sales getSalesHistory(int index) {
        if(this.count == 0) return null;
        if(index >= count) throw new IndexOutOfBoundsException(index);
        return this.salesHistory[index];
    }

    public void setSalesHistory(Sales s){

        salesHistory[count] = s;

        count = count +1;

    }

    public double calcTotalSales(){

        // calculates total sales for the salesperson
        
        // code missing
        double totalSales = 0;

        for(Sales sale : salesHistory){
            if(sale == null) break;
            totalSales += sale.totalRevenue();
        }
        
        return totalSales;

    }
        
         
        
    public Sales largestSale(){
        
    // calculates the sale with the largest value
        
    // code missing
        if (this.count == 0) return null;

        Sales largestSale = salesHistory[0];

        for(Sales sale : salesHistory){largestSale = largestSale.totalRevenue() < sale.totalRevenue() ? sale : largestSale;}
        
        return largestSale;
    }
}