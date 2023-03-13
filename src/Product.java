public class Product {
    private int productID;
    private String name;
    private Unit unit;
    private String type;
    private int availableQuantity;

    public Product(int productID, String name, Unit unit, String type, int availableQuantity) {
        this.productID = productID;
        this.name = name;
        this.unit = unit;
        this.type = type;
        this.availableQuantity = availableQuantity;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
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
}
