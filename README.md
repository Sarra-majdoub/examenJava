# E-commerce Console Application

The E-commerce Console
Application is a Java-based
platform emulating essential 
aspects of an online shopping platform .
The application incorporates features such as user
authentication, product management, 
shopping cart operations and payment processing.

# Design Decisions
### 1. Object-Oriented Programming (OOP) Implementation
The project follows OOP principles to enhance code organization :

&nbsp;&nbsp;&nbsp;&nbsp;Inheritance: create a hierarchy 
of product types, with an abstract Product class 
serving as the base for specific categories like
'Phone' and 'Jackets'.
&nbsp;&nbsp;&nbsp;&nbsp;Polymorphism: treating 
objects of derived classes uniformly 
promoting flexibility and extensibility
### 2.Optional Features Implemented 
#### a.Discounts 
&nbsp;&nbsp; Introduced a 'Order'
class that manages
user's purchases and apply a discount
based on the code provided.
#### b.Shipping Options
&nbsp;&nbsp;Introduces a 'Shipping'
class that applies the shipping option 
provided byt the user and adds the shipping cost
to the cart.
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

## How to run
#### Clone the repository: git clone (https://github.com/Sarra-majdoub/examenJava.git )
#### Compile the Java files: javac -d . src/*.java
#### Run the application: java Main 

