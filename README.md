
# E-commerce console application 
#### The e-commerce console application is a Java-based platform that emulates important aspects of  online shopping platforms.
#### This application has functions such as user authentication, product management, shopping cart operation, and payment processing. 
## design decisions 
### 1.  Implementation of object-oriented programming (OOP). 
&nbsp;&nbsp; The project follows OOP principles to improve code organization :

&nbsp;&nbsp; Inheritance: Create a hierarchy of product types using an abstract product class  as the basis for a specific category, such as "phone" or "jacket."
&nbsp;&nbsp; Polymorphism: Treating objects in derived classes in a consistent manner, promoting flexibility and extensibility. 

## 2. Implementation of optional functions 
### a.Discount 
&nbsp;&nbsp; Introduces an Order class that manages the user's purchases and provides discounts based on the code provided. 
### b. Shipping options 
&nbsp;&nbsp; Introduces a "Shipping" class that applies user-specified shipping options and adds  shipping costs to  cart. 

## Project Structure
The project is organized into several 
classes,each focusing on specific
functionalities .
#### authentication:
Manages user login, logout based on
a list of users that have already signed in
before. To login in you have to enter the correct username and password that
match one of the users.
#### ShoppingCart:
Implements shopping cart operations 
such as :addToCart, updateQuantity and deleteFromCart.
#### Order:
Handles order processing , the payment 
and implements the discount feature.
#### Product:
An abstract class handling products
defining common attributes 
and methods, while
subclasses (Jackets and Phone) 
introduce specific 
attributes and behaviors 
for their respective
product types.

## How to Run
```bash
# Clone the repository
git clone https://github.com/Sarra-majdoub/examenJava.git

# Compile the Java files
javac -d . src/*.java

# Run the application
java Main


