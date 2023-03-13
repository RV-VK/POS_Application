public class Store {
    private String name;
    private long phoneNumber;
    private String Address;
    private int GSTCode;

    public Store(String name, long phoneNumber, String address, int GSTCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        Address = address;
        this.GSTCode = GSTCode;
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
