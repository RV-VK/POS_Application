import java.util.Date;
import java.util.List;

public class Sales {
    private Date date;
    private int salesID;
    private List<SalesItem> salesItems;
    private double grandtotal;
    private paymentMode paymode;

    public Sales(Date date, int salesID, List<SalesItem> salesItems, double grandtotal, paymentMode paymode) {
        this.date = date;
        this.salesID = salesID;
        this.salesItems = salesItems;
        this.grandtotal = grandtotal;
        this.paymode = paymode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSalesID() {
        return salesID;
    }

    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }

    public List<SalesItem> getSalesItems() {
        return salesItems;
    }

    public void setSalesItems(List<SalesItem> salesItems) {
        this.salesItems = salesItems;
    }

    public double getGrandtotal() {
        return grandtotal;
    }

    public void setGrandtotal(double grandtotal) {
        this.grandtotal = grandtotal;
    }

    public paymentMode getPaymode() {
        return paymode;
    }

    public void setPaymode(paymentMode paymode) {
        this.paymode = paymode;
    }
}
