public class Cheese { ;
    private int id;
    private String name;
    private double price;
    private double quantity;


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

    @Override
    public String toString() {
        return "ID: " + id + " / Name: " + name + " / Price per kg: " + price + " / Quantity: " + quantity + " kg";
    }
}


