public class Store {
    private String name;
    private long phoneNumber;
    private String Address;
    private int GSTCode;
    private double investment;
    private double currentBalance;

    public Store(String name, long phoneNumber, String address, int GSTCode,double investment) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        Address = address;
        this.GSTCode = GSTCode;
        this.investment=investment;
        this.currentBalance=investment;

    }

    public Store() {

    }

    public double getInvestment() {
        return investment;
    }

    public void setInvestment(double investment) {
        this.investment = investment;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Store{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", Address='" + Address + '\'' +
                ", GSTCode=" + GSTCode +
                ", investment=" + investment +
                ", currentBalance=" + currentBalance +
                '}';
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getGSTCode() {
        return GSTCode;
    }

    public void setGSTCode(int GSTCode) {
        this.GSTCode = GSTCode;
    }
}
