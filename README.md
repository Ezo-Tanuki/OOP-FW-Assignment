# Forum Activity: Class Design and Implementation Case
To do:

1. Give answers to what is being asked for.

2. Implement the SalesPerson and Sales class, in addition, create a Driver class to simulate and test the validity of your code.

3. Upload all answers in your GitHub repo and share it as your reply to this thread.

---

A large company with locations in different cities has taken an OOP approach in creating an administration program that manages all aspects of its business. These aspects include:

- the sale of all the different products that the company manages

- the salaries for managers, office staff and sales personnel.

 

1.(a) By making use of an example from the above scenario, distinguish between a class and an instantiation of a class. (3 points)

- A class can be considered the template that holds the characteristics and behavior of an object, which can also be described as a "custom data type". The instantiation of a class is the declaration or creation of an object that follows the behavior of the class. 

- The application of OOP that can be applied to the aforementioned scenario is creating the class `Sale` that details the __quantity__ of the item sold, the __price__ of the item, and the __identifier__ for the item. Then you can create a method `totalSale` that calculates the total sale for the item. For instance, the instantiation of the `Sale` __class__ can be declared or stored in the `appleSales` variable, which contains the total amount of apples sold  (quantity), the price of an apple (price), and the code for the apple (identifier). After that, by calling the method `totalSale` on the `appleSales` variable, it will calculate the total sale for apple.

The different modules in the program each open a graphical user interface (GUI). Each GUI has a similar design but contains differences specific to each module.

(b) By giving two examples, explain how the principles of inheritance can be incorporated into the design of this administration program. (4 points)

- Inheritance could be used in a UI component that extends from the GUI parent class. When you are trying to create a button in the UI you can extend the GUI class and change the necessary attribute to be classified as a button.

- Another scenario would be employee. If you set employee as a superclass, you can extend it to many subclasses, such as manager, office staff, etc.

(c) Describe how the use of libraries can facilitate the development of programs like this company’s administration program. (3 points)

- Using the available libraries could accelerate the development of a program since a libraries provide a collection of classes and functions that are generally useful. Building a library for mathematical tasks from scratch would take a huge amount of work; however, we can use the Java Standard Library (JSL) since Java provides a library to execute mathematical tasks.

2\. The company employs several sales personnel to sell its products to different retailers. Each branch of the company keeps track of its own sales with a suite of programs that include the two classes SalesPerson and Sales.
 
```

public class SalesPerson {

    // each object contains details of one salesperson

    private String id;

    private Sales[] salesHistory; // details of the different sales

    private int count = 0; // number of sales made



    //constructor for a new salesperson

    public SalesPerson(String id){

    // code missing

    }

    

    // constructor for a salesperson transferred (together with their sales details) from another branch

    public SalesPerson(String id, Sales[] s, int c){

    // code missing

    }

    

    public int getCount(){return count;}

    public String getId() {return id;}

    public void setSalesHistory(Sales s){

    salesHistory[count] = s;

    count = count +1;

    }

    

    public double calcTotalSales(){

    // calculates total sales for the salesperson

    // code missing

    }

    

    public Sales largestSale(){

    // calculates the sale with the largest value

    // code missing

    }

}

```

Each instance variable is initialized when a SalesPerson object is instantiated.

(a) Complete the constructor public SalesPerson(String id), from the SalesPerson class. (2 points)

```
...
    public SalesPerson(String id){

    // code missing
        this.salesHistory = new Sales[100];
        this.id = id;

    }
...
```

(b) Explain why accessor methods are necessary for the SalesPerson class. (3 points)

- Most classes usually have their attribute set to `private` to prevent any unwanted direct access to the attribute, which can cause fatal security issues. So, in order to retrieve the `private` attribute, we use the accessor method.

```

public class Sales {

    // each object contains details of one sale

    private String itemId;     // id of the item

    private double value;      // the price of one item

    private int quantity;      // the number of the items sold

    // constructor missing

    public double getValue() {return value;}

    public int getQuantity() {return quantity;}

}

```

(c) (i) Construct unified modelling language (UML) diagrams to clearly show the relationship between the SalesPerson and Sales classes.

Note: There is no need to include mutator or accessor methods or a constructor. (4 points)

(c) (ii) Outline a negative effect that a future change in the design of the Sales object might have on this suite of programs. (2 points)

- If there are changes in the `SalesPerson` class, the `Sales` class also has to be changed in order to be compatible, since the `SalesPerson` class has the `calcTotalSales` method that depends entirely on the `Sales` class.

The company employs several sales personnel. The different salesPerson objects are held in the array salesPeople. The Driver class contains various methods that operate on the SalesPerson and Sales classes. The Driver class contains the following code:

```

public static void main(String[] args){

    SalesPerson[] salesPeople = new SalesPerson[6];

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

```

(d) State the output after running this code. (4 points)

```
102
2
2550.4
5000.0
```

(e) Construct the method calcTotalSales(), in the SalesPerson class that calculates the total value of the sales for a specific SalesPerson object. (5 points)

```
...
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
...
```

The salesPeople array contains 100 instantiated objects. The company wishes to reward the salesperson whose sales have the largest total value.

(f) By making use of any previously written methods, construct the method highest(), that returns the ID of the salesperson whose sales have the largest total value. (5 points)

```
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
```

(g) Construct the method addSales(Sales s, String id), in the Driver class, that will add a new Sales object s, to the salesperson with a specified ID.

Note: You can assume that the ID is a valid one. (4 points)

```
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
```

A further class in this suite of programs is the Payroll class. This class is run at the end of each month to calculate each salesperson’s salary, which is based on the sales that have been made during that month.

(h) Suggest changes that must be made to the SalesPerson class and/or the Sales class to allow these calculations to be made. (3 points)

- In the `Sales` class we can add the missing setter method which is useful in case of a mistake or typo in the inputting process. Another method can also be added to calculate the total revenue for the given item. Same goes to the `SalesPerson` class, we can add the missing setter.

(i) Discuss the use of polymorphism that occurs in this suite of programs. (3 points)

- We can see the use of polymorphism in the `SalesPerson` class. As you can see, there are two seperate constructors inside the `SalesPerson` class, which is one of the implementations of polymorphism.