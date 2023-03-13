public class Unit {
    private String name;
    private String Description;
    private boolean isDividable;

    public Unit(String name, String description, boolean isDividable) {
        this.name = name;
        Description = description;
        this.isDividable = isDividable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isDividable() {
        return isDividable;
    }

    public void setDividable(boolean dividable) {
        isDividable = dividable;
    }


}
