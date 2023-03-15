import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private String productID;
    private String name;
    private Unit unit;
    private String type;
    private int availableQuantity;

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    private double costPrice;
    static List<Product> productList=new ArrayList<>();

    public Product(String productID, String name, Unit unit, String type, double costPrice) {
        this.productID = productID;
        this.name = name;
        this.unit = unit;
        this.type = type;
        this.costPrice = costPrice;
    }

    public Product(String productID, String name, Unit unit, String type,int availableQuantity,double costPrice) {
        this.productID = productID;
        this.name = name;
        this.unit = unit;
        this.type = type;
        this.availableQuantity=availableQuantity;
        this.costPrice=costPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", name='" + name + '\'' +
                ", unit=" + unit +
                ", type='" + type + '\'' +
                ", availableQuantity=" + availableQuantity +
                '}';
    }

    public static void showProducts() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection productConnection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/POSDatabase","postgres","manikantan1205");
        Statement getProductStatement=productConnection.createStatement();
        ResultSet productResultSet=getProductStatement.executeQuery("SELECT * FROM PRODUCT");
        while(productResultSet.next())
        {
            productList.add(new Product(productResultSet.getString(1),productResultSet.getString(2),new Unit(productResultSet.getString(3)),productResultSet.getString(4),productResultSet.getDouble(5)));
        }
        System.out.println("PRODUCT ------ LIST");
        for(Product product:productList)
        {
            System.out.println(product.getName());
        }
    }
}
