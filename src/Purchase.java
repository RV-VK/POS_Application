import java.util.Date;
import java.util.List;

public class Purchase {
    private int purchaseID;
    private Date date;
    List<PurchaseItem> purchaseItems;
    private double grandtotal;

    public Purchase(int purchaseID, Date date, List<PurchaseItem> purchaseItems, double grandtotal) {
        this.purchaseID = purchaseID;
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
}
