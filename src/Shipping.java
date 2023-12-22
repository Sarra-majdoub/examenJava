public class Shipping {
    protected String name;
    protected float cost;
    public Shipping(String name) {
        this.name = name;
        if ( name.equals("StandarShipping") ){
            this.cost=5;
        }else{
            this.cost=10;
        }
    }
    static void display(){
        System.out.println("StandardShipping :" + 5
                + " , ExpressShipping : "+ 10 );
    }

}
