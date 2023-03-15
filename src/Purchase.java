import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Purchase {
    private int purchaseID;
    private Date date;
    List<PurchaseItem> purchaseItems;
    private double grandtotal;
    private static int idCounter=1000;

    public Purchase( Date date, List<PurchaseItem> purchaseItems, double grandtotal) {
        this.purchaseID = idCounter++;
        this.date = date;
        this.purchaseItems = purchaseItems;
        this.grandtotal = grandtotal;

    }

    public int getPurchaseID() {
        return purchaseID;
    }

    public void setPurchaseID(int purchaseID) {
        this.purchaseID = purchaseID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<PurchaseItem> getPurchaseItems() {
        return purchaseItems;
    }

    public void setPurchaseItems(List<PurchaseItem> purchaseItems) {
        this.purchaseItems = purchaseItems;
    }

    public double getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(double grandtotal) {
        this.grandtotal = grandtotal;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseID=" + purchaseID +
                ", date=" + date +
                ", purchaseItems=" + purchaseItems +
                ", grandtotal=" + grandtotal +
                '}';
    }
    public static void purchase() throws ClassNotFoundException, SQLException {
        Scanner scanner=new Scanner(System.in);
        Class.forName("org.postgresql.Driver");
        List<PurchaseItem> purchaseItemList=new ArrayList<>();
        Connection purchaseConnection= DriverManager.getConnection("jdbc:postgresql://localhost:5432/POSDatabase","postgres","manikantan1205");
        Product.showProducts();
        do {
            System.out.println("Enter the name or id of the product to be purchased (OR) Enter 'Stop' to Stop the purchase");
            String productName = scanner.nextLine();
            if(productName.equalsIgnoreCase("Stop"))
            {
                break;
            }
            else {
                Product purchaseProduct = null;
                int foundflag = 0;
                for (Product product : Product.productList) {
                    if (productName.equalsIgnoreCase(product.getName()) || productName.equals(product.getProductID())) {
                        purchaseProduct = product;
                        foundflag++;
                    } else {
                        continue;
                    }
                }
                if (foundflag > 0) {
                    System.out.println("Enter the Quantity to be Purchased");
                    float quantity;
                    while (true) {
                        quantity = scanner.nextFloat();
                        if (!purchaseProduct.getUnit().isDividable()) {
                            if (quantity % 1 != 0) {
                                System.out.println("Not a Dividable Quantity Please Enter a Whole Number!");
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    double unitPrice = purchaseProduct.getCostPrice();
                    PurchaseItem purchaseItem = new PurchaseItem(purchaseProduct, quantity, unitPrice);
                    purchaseItemList.add(purchaseItem);
                }
                else {
                    System.out.println("Not Found! Please Ensure you have Entered a Valid or Available Product!");
                }
                scanner.nextLine();
            }
        }while(true);

        if(purchaseItemList.size()==0)
        {
            System.out.println("Nothing Purchased Now");
        }
        else
        {
            double totalPurchasePrice=0;
            for(PurchaseItem purchaseItem:purchaseItemList)
            {
                totalPurchasePrice+=(purchaseItem.getUnitPurchasePrice()*purchaseItem.getQuantity());
            }
            Date date=new Date();
            Purchase purchase=new Purchase(date,purchaseItemList,totalPurchasePrice);
            System.out.println("BOOYAH! PURCHASE COMPLETED!\n");
            System.out.println("--------PURCHASE BILL---------");
            System.out.println("PURCHASE ID : "+purchase.getPurchaseID());
            System.out.println("PRODUCT\t\tQUANTITY\t\t|PRICE|");
            for(PurchaseItem purchaseItem:purchaseItemList)
            {
                System.out.print(purchaseItem.getProduct().getName()+"\t");
                System.out.print(purchaseItem.getQuantity()+"\t\t");
                System.out.print(purchaseItem.getUnitPurchasePrice()*purchaseItem.getQuantity());
                System.out.println();
            }
            System.out.println("------GRAND PRICE : "+totalPurchasePrice+"--------");
            Statement purchaseUpdate=purchaseConnection.createStatement();
            ResultSet currentBalanceSet=purchaseUpdate.executeQuery("SELECT CURRENTBALANCE FROM STORE");
            double currentBalance = 0;
            while(currentBalanceSet.next()) {
                currentBalance= currentBalanceSet.getDouble(1);
            }
            double updatedBalance= currentBalance-totalPurchasePrice;
            PreparedStatement purchaseUpdateStatement=purchaseConnection.prepareStatement("UPDATE STORE SET CURRENTBALANCE=?");
            purchaseUpdateStatement.setDouble(1,updatedBalance);
            purchaseUpdateStatement.executeUpdate();
        }
    }
}
