# BookStore

### Technologies used :

1. Spring Boot 2.1.2.RELEASE

2. Spring 5.1.4.RELEASE

3. postgresql  12.2

4. Maven 2.22.0

5. Java 8

### **How to prepare for launch app**
1. Install PostgresSQL >=12.2
2. Create PostgresSQL database from: 
src/main/resources/Scripts/SQL scripts.txt
3. Fill in the information about the created Database in DatabaseManager 
src/main/java/com/termos/config/DatabaseManager.java
4. Install Postman 
5. In Postman use Http method with URL
  
**Example Book, Order, User Jsons in:** src\main\resources\Jsons

**HTTP** Method	URI	Description
###### **Books,**

**GET**	/books	List all books.

**GET**	/book/{id}	Find a book where id = {:id}.

**POST**	/book	Save a book.

**PUT**	/book/{id}	Update a book where id = {:id}, or save it.

**DELETE**	/book/{id}	Delete a book where id = {:id}.
 
######  **Users,** 

**GET**	/users	List all users.

**GET**	/user/{id}	Find a user where id = {:id}.

**POST**	/user	Save a user. 

**PUT**	/user/{id}	Update a user where id = {:id}, or save it.

**DELETE**	/user/{id}	Delete a user where id = {:id}.

######  **Orders,**
 
 **GET**	/orders	List all orders.
 
 **GET**	/order/{id}	Find a order where id = {:id}.
 
 **POST**	/order	Save a order. 
 
 **PUT**	/order/{id}	Update a order where id = {:id}, or save it.
 
 **DELETE**	/order/{id}	Delete a order where id = {:id}.
 
 
