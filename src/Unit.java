public class Unit {
    private String name;
    private boolean isDividable;

    public Unit(String name) {
        this.name = name;
        if(name.equalsIgnoreCase("Pieces")||name.equalsIgnoreCase("Pack"))
        {
            this.isDividable=false;
        }
        else {
            this.isDividable=true;
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public boolean isDividable() {
        return isDividable;
    }

    public void setDividable(boolean dividable) {
        isDividable = dividable;
    }


}
