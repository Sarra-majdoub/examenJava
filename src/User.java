import java.util.Scanner;

 abstract class  User {
    protected String username;
    protected String password;
    protected String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}
class Admin extends User{
     public Admin(String username, String password, String role) {
        super(username, password, role);
    }
}
class Customer extends User{

    public Customer(String username, String password, String role) {
        super(username, password, role);
    }
}