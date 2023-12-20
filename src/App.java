import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    /*-------------------database----------------------------*/
    private static ProductManager p = new ProductManager();
    private static List<User> users = new ArrayList<>();
    private static User currentUser=null;

    private static ShoppingCart shoppingCart = new ShoppingCart();
    private static List<Order> orderHistory = new ArrayList<>();


    public static void main(String[] args) {

        //adding our products
        Product phone1 = new Phone(1, "13pro", 500, 8, "Apple");
        Product phone2 = new Phone(2, "14pro", 700, 5, "Apple");
        Product phone3 = new Phone(3, "15pro", 800, 4, "Apple");

        Product jacket1= new Jackets(4, "j1", 50, 40, "M");
        Product jacket2= new Jackets(5, "j2", 30, 40, "S");
        Product jacket3= new Jackets(6, "j3", 20, 3, "XL");


        p.addProduct(phone1);
        p.addProduct(phone2);
        p.addProduct(phone3);
        p.addProduct(jacket1);
        p.addProduct(jacket2);
        p.addProduct(jacket3);

        //adding users that have already signed in before
        User user1= new User("sarra","123","customer");
        User user2= new User("iyed","123","customer");
        User user3= new User("yassine","0000","customer");

        users.add(user1);
        users.add(user2);
        users.add(user3);

        /*--------------------------------------------------------------------------------*/

        System.out.println("You are currently using our E-commerce app ! ");

        int choice=0 ;
        while (choice!=8) {
            Menu();
            choice =Choice();
            switch (choice) {
                case 1:
                    currentUser=login();
                    break;
                case 2:
                    System.out.println("our products:");
                    p.displayProducts();
                    break;
                case 3:
                    //add products to your cart
                    addToShoppingCart() ;
                    break;
                case 4:
                    //delete a product from your  Cart
                    DeletItemFromCart();
                    break;
                case 5:
                    //update your cart
                    update();
                    break;
                case 6:
                    OrderProcessing();
                    break;
                case 7:
                    logout(currentUser);
                    break;
                case 8:
                    exit();
                    break;
                case 9:
                    shoppingCart.display();
                    System.out.println("your total amount is :"+shoppingCart.totalAmount() );
                    break;
                default:
                    System.out.println("Invalid choice. Please try again, choose : 1 , 2 , 3 , 4 , 5 , 6 , 7  ou 8 ");
            }
        }
    }
    public static int Choice() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine();
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }
    public static void Menu() {
        System.out.println("--------------------|| E-Commerce Application ||------------");
        System.out.println("1. Login");
        System.out.println("2. check our products ");
        System.out.println("3. Add Product to Cart");
        System.out.println("4. Delete an Item from your Cart");
        System.out.println("5. update your cart ");
        System.out.println("6. Order Processing");
        System.out.println("7. Logout");
        System.out.println("8. Exit");
        System.out.println("9. view your cart ");
        System.out.print("Enter your choice: ");
    }


    public static User login(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();


        System.out.print("Enter your role (admin /customer): ");
        String role = scanner.nextLine();

        while (!"admin".equals(role) && !"customer".equals(role)) {
            System.out.print("Enter your role (admin /customer): ");
            role = scanner.nextLine();
        }


        User authenticatedUser = authenticateUser(username, password,role);

        if (authenticatedUser != null) {
            currentUser = authenticatedUser;
            System.out.println("Login successful. Welcome, " + currentUser.getUsername() + "!");
            if ("admin".equals(currentUser.getRole())) {
                System.out.println("You have admin privileges.");
            } else if ("customer".equals(currentUser.getRole())) {
                System.out.println("You have customer privileges.");
                }
        } else {
            System.out.println("Invalid username or password. Login failed.");
        }


       return currentUser;
    }
    public static User authenticateUser(String username, String password, String role) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password) && user.getRole().equals(role)) {
                return user;
            }
        }
        return null;
    }

    private static void addToShoppingCart() {
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }
        System.out.println("our available products: ");
        p.displayProducts();
        System.out.println("Enter the product ID to add to the cart: ");

        int productId = scanner.nextInt();

        Product selectedProduct = exist(productId,p.products);
        System.out.println("Enter the quantity: ");
        int quantity = scanner.nextInt();

        if (selectedProduct != null) {

            if (quantity <= selectedProduct.getStockQuantity()){

                shoppingCart.addToCart(selectedProduct,quantity);

                System.out.println("Product added to the cart.");
                System.out.println("Your total amount is : " + shoppingCart.totalAmount());

            } else{

                System.out.println("products out of stock");
            }
        }else {

            System.out.println("Product not found.");
        }
    }
    static void DeletItemFromCart(){

        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }
        shoppingCart.display();

        System.out.println("Enter the product ID to delete from the cart: ");

        int productId = scanner.nextInt();

        Product toBeDeletedProduct = exist(productId,p.products);

        if (toBeDeletedProduct != null) {
            shoppingCart.deleteFromCart(toBeDeletedProduct);
        } else {
            System.out.println("the Id provided does not match any product .");
        }
    };
    static void update(){
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }
        System.out.println("Enter the product ID to update the quantity : ");

        int productId = scanner.nextInt();


        Product toBeUpdatedProduct = exist(productId,p.products);

        if (toBeUpdatedProduct != null) {
            System.out.println("Enter the new quantity : ");
            int x = scanner.nextInt();
            shoppingCart.updatQuantity(toBeUpdatedProduct,x);


        } else {
            System.out.println("the Id provided does not match any product .");
        }
    };
    static void OrderProcessing() {
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }

        System.out.println("to finalize your order please enter your information:");

        Random random = new Random();
        int OrderId= random.nextInt(100000);

        Order newOrder= new Order(OrderId,currentUser.getUsername(),shoppingCart.totalAmount());

        String method;

        System.out.println("choose your Shipping Method : StandardShipping :" + 5 + "$ || ExpressShipping : " + 10+"$ :" );
        method= scanner.next();

        while (!method.equals("StandardShipping") && !method.equals("ExpressShipping")){
            System.out.println("choose the correct  shipping method : StandardShipping :" + 5 + "$ || ExpressShipping : " + 10+" $ :" );
            method= scanner.next();
        }
        Shipping m = new Shipping(method);

        newOrder.setShippinMethod(m);

        newOrder.display();

        newOrder.payment();

        orderHistory.add(newOrder);
    }
    public static Product exist(int id, List<Product> products){

        Product testProduct = null;
        for ( Product p : products ) {
            if ( p.getId()== id ) {
                testProduct = p;
                break;
            }
        }
        return testProduct;
    };

    public static void logout(User currentUser){
        if (currentUser == null) {
            System.out.println("Please log in first.");
            return;
        }

        System.out.print("logging out... See you soon ");
        currentUser=null;
    }
    private static void exit() {
        System.out.println("Exiting the application. Thank you!");
        System.exit(0);
    }
}
