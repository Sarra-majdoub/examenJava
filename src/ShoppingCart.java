import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    Map<Product, Integer> cart;
    ShoppingCart(){

        cart = new HashMap<>();
    }

    void addToCart(Product p, int quantity){
        if( cart.containsKey(p)){

            cart.put( p , cart.get(p)+quantity );
        }else{
        cart.put(p, quantity);
        }
    }

    float totalAmount(){
        float s=0;
        for (Map.Entry<Product, Integer> set :
                cart.entrySet()){

            s=s+( (set.getKey() ).getPrice() * set.getValue() );
        }
        return s;
    }
    int getQuantityByProduct(Product p){
        return cart.get(p);
    }

    void display(){
        if (cart.isEmpty()) {
            System.out.println("your cart is empty");
        }
        else{
            for (Map.Entry<Product, Integer> set :
                cart.entrySet()){
            System.out.println("you cart :");
            System.out.println(" { name:"+ set.getKey().getName() +", Id: "+set.getKey().getId()+
                    " ,quantity: " + set.getValue()+" , price :" +set.getKey().getPrice() +" } ");
            }
        }
    }
    void deleteFromCart(Product p){
        cart.remove(p);
        System.out.println("Item deleted");
    }

    void updatQuantity(Product p , int newQuantity){
        if ( cart.containsKey(p)){
            cart.put(p,newQuantity);
            System.out.println("Cart updated");
        }else{
            System.out.println("your cart does not contain the product you want to update ");
        }
    }
}
