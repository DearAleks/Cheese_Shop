public class Cheese { ;
    private int id;
    private String name;
    private double price;
    private double quantity;
    private double boughtQuantity;

    public Cheese(int id, String name, double price, double quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return price;
    }
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
    public double getQuantity() {
        return quantity;
    }
    public void setBoughtQuantity(double boughtQuantity) {
        this.boughtQuantity = boughtQuantity;
    }
    public double getBoughtQuantity() {
        return boughtQuantity;
    }
}
