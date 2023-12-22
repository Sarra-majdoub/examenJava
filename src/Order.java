import java.util.Map;
import java.util.Scanner;

public class Order {
    protected Shipping shippingMethod ;
    protected String userName;
    protected int OrderId;
    protected String address;
    protected String mail;
    protected float totalAmount;
    protected boolean paid=false;
    protected String discountCode;
    Order(int OrderId,String name,float totalAmount){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your address : ");
        String address = scanner.nextLine();

        System.out.println("email address (example@mail.com): ");
        String mail= scanner.nextLine();

        this.OrderId=OrderId;
        this.address=address;
        this.totalAmount=totalAmount;
        this.mail=mail;
        this.userName=name;
    }
    void setShippinMethod(Shipping m){
        this.shippingMethod=m;
    }
    void display(){
        System.out.println("-------------order----------");
        System.out.println("name: "+userName);
        System.out.println("YOUR ORDER IS BEING SHIPPED TO :");
        System.out.println("   address: "+address);
        System.out.println("Shipping Method: "+ shippingMethod.name);
        System.out.println("Your shipping cost: "+  shippingMethod.cost );
        System.out.println("Your amount: "+  totalAmount );
        System.out.println("Your total  amount: "+  totalAmount+shippingMethod.cost );
        System.out.println(" #order"+OrderId+"\n Thank you "+userName+"!"+" Your order is confirmed ");

        this.totalAmount=this.totalAmount+shippingMethod.cost;
    }
    void setDiscountCode(){
        this.totalAmount= (float) (this.totalAmount*(0.7));
    };
    void payment(){
        Scanner scanner = new Scanner(System.in);


        System.out.println("enter your discount code :");
        String code = scanner.next();
        if (code.equals("GL2")){
            System.out.println("A discount will be applied to your order ");
            setDiscountCode();
        }

        System.out.println("Processing payment of $" + totalAmount);

        System.out.println("ACCOUNT INFORMATION ");

        System.out.println("PAYMENT METHOD: VISACard, MasterCard,PayPal , DiscoverCard ,AmericanExpress :");
        String method = scanner.next();

        System.out.println(" Provide your card number");
        int number = scanner.nextInt();

        System.out.println("please wait... ");
        paid=true;
        System.out.println("Successful Payment ! Thank you for your purchase! ");
    }

}
