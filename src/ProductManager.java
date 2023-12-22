import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    protected  List<Product> products = new ArrayList<>();
   //contient tous nos produits et lutilisateur doit choisir parmis ces produits
    public ProductManager(){

    }
    public void displayProducts() {
        for (Product product : products) {
            System.out.println(product.toString());
        }
    }
    void updateQuantityAfterOrdering(int ProductId, int q){

        for( Product product: products){

            if( product.getId()==ProductId){

                product.setStockQuantity(product.getStockQuantity()-q);
            }
        }
    };
    public void addProduct(Product newProduct) {
        for (Product product : products){
            if (newProduct.getId()==product.getId()){
                System.out.println("Product must have a unique id");
                return;
            }
        }
        products.add(newProduct);

    }
    public void updateProductStock(int productId, int quantity) {
        for (Product product : products) {
            if (product.getId()==productId) {
                int newStockQuantity = product.getStockQuantity() + quantity;
                product.setStockQuantity(newStockQuantity);
                System.out.println("Stock quantity updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }
    public void deleteProduct(int productId) {
        products.removeIf( product -> product.getId()==productId );
        System.out.println("Product deleted successfully.");
    }

}
