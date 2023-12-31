abstract class Product {
    protected int id;

    protected String name;
    protected float price;
    protected int Quantity;
    public Product(int id, String name, float price, int Quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.Quantity = Quantity;
    }
    int getId(){
        return id;
    }
    public int getStockQuantity() {
        return Quantity;
    }
    public String getName(){
        return name;
    }
    public float getPrice(){
        return price;
    }
    public void setStockQuantity(int stockQuantity) {
        this.Quantity = stockQuantity;
    }
    public abstract String displayInfo();
    public abstract void updatePrice(float newPrice);

}
class Jackets extends Product  {

    protected String size;
    public Jackets(int id, String name, float price, int Quantity, String size) {
        super(id, name, price, Quantity);
        this.size = size;
    }

    @Override
    public void setStockQuantity(int stockQuantity) {
        this.Quantity=stockQuantity;
    }

    @Override
    public String displayInfo() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ",size= "+size+
                '}';
    }
    @Override
    public void updatePrice(float newPrice) {
        this.price=newPrice;
    }
}
class Phone extends Product {
    protected String brand;
    public Phone(int id, String name, float price, int Quantity, String brand){
        super(id,name,price,Quantity);
        this.brand=brand;
    }
    @Override
    public String displayInfo() {
        return "{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ",Brand= " + brand +
                '}';
    }

    @Override
    public void updatePrice(float newPrice) {
        this.price=newPrice;
    }

}