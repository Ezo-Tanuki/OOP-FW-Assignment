package src;


public class Main {
    static SalesPerson[] salesPeople;

    public String highest(SalesPerson[] salesPeople){
        double max = Double.MIN_VALUE;
        String id = null;
    
        for(SalesPerson s : salesPeople){
            if(s == null) break;
            if(s.calcTotalSales() > max){
                id = s.getId();
                max = s.calcTotalSales();
            }
        }
    
        return id;
    }

    public static void addSales(Sales s, String id){
        SalesPerson target = null;

        for(SalesPerson sp : salesPeople){
            if(sp.getId() == id){
                target = sp;
                break;
            }
        }

        if(target == null) return;

        target.setSalesHistory(s);
    }
    public static void main(String[] args) {
        salesPeople = new SalesPerson[6];
        
        salesPeople[0] = new SalesPerson("100");
        
        salesPeople[1] = new SalesPerson("101");
        
        salesPeople[2] = new SalesPerson("102");
        
        salesPeople[0].setSalesHistory(new Sales("A100",300.00,10));
        
        salesPeople[0].setSalesHistory(new Sales("A200",1000.00,2));
        
        salesPeople[1].setSalesHistory(new Sales("A300",2550.40,10));
        
        System.out.println(salesPeople[2].getId());
        
        System.out.println(salesPeople[0].getCount());
        
        System.out.println(salesPeople[1].getSalesHistory(0).getValue());
        
        System.out.println(salesPeople[0].calcTotalSales());
        
        
    }
}
