public class PurchaseItem {
    private Product product;
    private float Quantity;
    private double unitPurchasePrice;


    public PurchaseItem(Product product, float quantity, double unitPurchasePrice) {
        this.product = product;
        Quantity = quantity;
        this.unitPurchasePrice = unitPurchasePrice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public float getQuantity() {
        return Quantity;
    }

    public void setQuantity(float quantity) {
        Quantity = quantity;
    }

    public double getUnitPurchasePrice() {
        return unitPurchasePrice;
    }

    public void setUnitPurchasePrice(double unitPurchasePrice) {
        this.unitPurchasePrice = unitPurchasePrice;
    }
}
