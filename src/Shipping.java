public class Shipping {
    protected String name;
    protected int cost;
    public Shipping(String name) {
        this.name = name;
        if ( name.equals("Standard Shipping") ){
            this.cost=5;
        }else{
            this.cost=10;
        }
    }
    static void display(){
        System.out.println("Standard Shipping :" + 5
                + " , Express Shipping : "+ 10 );
    }

}
