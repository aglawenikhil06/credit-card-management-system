# credit-card-management-system
The Credit Card Management System is a console-based Java application developed using the Spring Framework and Hibernate ORM to simulate basic credit card operations. The system allows customers to register, apply for credit cards, perform transactions within their assigned credit limit, generate monthly bills, and make bill payments. 

This project demonstrates the integration of Spring for dependency injection and application management with Hibernate ORM for efficient database interaction. The application follows a layered architecture where business logic, data access, and configuration are separated to ensure better maintainability and scalability.

The system stores and manages data using a MySQL relational database, ensuring structured data storage for customers, credit cards, transactions, billing, and payment records. 

The project mainly focuses on implementing CRUD operations, transaction processing, and bill generation logic while maintaining credit limits and transaction history for each credit card.

Key Features
--------------
Customer Registration
-------------------------
The system allows users to register new customers by storing their personal details such as name, email, mobile number, and address in the database.

Credit Card Application
-------------------------
Once a customer is registered, they can apply for a credit card. The system generates a unique card number and assigns a credit limit based on the provided input.

Credit Limit Management
-----------------------
Each credit card is assigned a credit limit. Whenever a transaction occurs, the system verifies whether the transaction amount is within the available limit before processing it.

Transaction Processing
----------------------
Customers can perform transactions using their credit card. Each transaction stores details such as merchant name, transaction amount, and transaction date.

Transaction History
-------------------
The system allows users to view all transactions made using a particular credit card, providing a complete transaction history.

Monthly Bill Generation
-------------------------
The system calculates the total amount spent using the credit card and generates a monthly bill containing details such as:

    Bill ID
    Card Number
    Total Amount
    Bill Date
    Due Date
   
Bill Payment
--------------
Customers can pay the generated bill amount using the bill ID. Once the payment is successful, the system restores the available credit limit.

Technologies Used
-----------------
    Layer	                   Technology
    Programming Language	   Java
    Framework	               Spring Framework
    ORM Tool	               Hibernate
    Database	               MySQL
    Development Tools	       Spring Tool Suite / IntelliJ IDEA / Eclipse
    Architecture	           Layered Architecture (DAO, Service, Entity)

System Architecture
---------------------
The project follows a layered architecture to maintain clean code and separation of concerns.

Entity Layer
------------
Contains Java classes representing database tables such as:

    Customer
    CreditCard
    Transaction
    Bill
    Payment

DAO Layer
----------
Handles database operations using HibernateTemplate. It is responsible for performing CRUD operations such as saving customers, retrieving card details, storing transactions, and managing billing information.

Service Layer
---------------
Contains business logic such as:

    validating credit limit before transaction
    calculating bill amount
    processing payments

Configuration Layer
-------------------
Spring configuration is used to manage bean creation, dependency injection, and Hibernate session factory configuration.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

Database Design
----------------
The system uses a relational database structure with the following tables.

Customer Table
----------------
Stores customer details.

Fields:

    - customer_id
    - name
    - email
    - mobile
    - address

CreditCard Table
-----------------
Stores credit card details assigned to customers.

Fields:

     - card_id
     - card_number
     - credit_limit
     - available_limit
     - customer_id

Transaction Table
-----------------
Stores transaction records performed using a credit card.

Fields:

     - transaction_id
     - card_number
     - amount
     - date
     - merchant

Bill Table
------------
Stores generated monthly bills.

Fields:

     - bill_id
     - card_number
     - total_amount
     - bill_date
     - due_date

Payment Table
--------------
Stores payment records made against bills.

Fields:

     - payment_id
     - bill_id
     - amount
     - payment_date

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

Application Workflow
----------------------

Step 1: Register Customer
-------------------------
The user enters customer details and the system stores them in the database with a unique customer ID.

Step 2: Apply for Credit Card
------------------------------
The customer applies for a credit card by providing the customer ID and desired credit limit. The system generates a unique card number and assigns the available credit limit.

Step 3: Make Transaction
---------------------------
The user performs a transaction using the card number. The system verifies the available credit limit before processing the transaction.

Step 4: View Transaction History
--------------------------------
The system retrieves all transactions associated with the card and displays the transaction history.

Step 5: Generate Monthly Bill
------------------------------
The system calculates the total transaction amount and generates a bill with billing details and due date.

Step 6: Pay Bill
-----------------
The user enters the bill ID and payment amount. After successful payment, the available credit limit is restored.

-- ----------------------------------------------------------------------------------------------------------------------------------------------------------------
 
Console Menu Example
------------------------

===== CREDIT CARD MANAGEMENT SYSTEM =====

    1. Register Customer
    2. Apply for Credit Card
    3. View Credit Card Details
    4. Make Transaction
    5. View Transactions
    6. Generate Bill
    7. Pay Bill
    8. Exit

-------------------------------------------------------------------------------------------------------------------------------------------------------------------

Key Concepts Demonstrated
-------------------------
Spring Dependency Injection
Hibernate ORM mapping
DAO design pattern
Database transaction handling
CRUD operations
Layered architecture
Console-based application design
