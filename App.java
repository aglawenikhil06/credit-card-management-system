package com.orm;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.orm.dao.*;
import com.orm.entity.*;

public class App {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("config.xml");

        CustomerDao customerDao = context.getBean("customerDao", CustomerDao.class);
        CreditCardDao cardDao = context.getBean("creditCardDao", CreditCardDao.class);
        TransactionDao transactionDao = context.getBean("transactionDao", TransactionDao.class);
        BillDao billDao = context.getBean("billDao", BillDao.class);
        PaymentDao paymentDao = context.getBean("paymentDao", PaymentDao.class);

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== CREDIT CARD MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Apply for Credit Card");
            System.out.println("3. View Credit Card Details");
            System.out.println("4. Make Transaction");
            System.out.println("5. View Transactions");
            System.out.println("6. Generate Bill");
            System.out.println("7. Pay Bill");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                // REGISTER CUSTOMER
                case 1:

                    sc.nextLine();

                    Customer customer = new Customer();

                    System.out.print("Enter Name: ");
                    customer.setName(sc.nextLine());

                    System.out.print("Enter Email: ");
                    customer.setEmail(sc.nextLine());

                    System.out.print("Enter Mobile: ");
                    customer.setMobile(sc.nextLine());

                    System.out.print("Enter Address: ");
                    customer.setAddress(sc.nextLine());

                    Long id = customerDao.saveCustomer(customer);

                    System.out.println("Customer Registered Successfully!");
                    System.out.println("Customer ID: " + id);

                    break;

                // APPLY CREDIT CARD
                case 2:

                    System.out.print("Enter Customer ID: ");
                    Long custId = sc.nextLong();

                    Customer cust = customerDao.getCustomer(custId);

                    if (cust == null) {
                        System.out.println("Customer not found!");
                        break;
                    }

                    System.out.print("Enter Credit Limit: ");
                    double limit = sc.nextDouble();

                    CreditCard card = new CreditCard();

                    card.setCustomer(cust);
                    card.setCreditLimit(limit);
                    card.setAvailableLimit(limit);

                    String cardNumber = "5432-XXXX-XXXX-" + (int)(Math.random()*10000);
                    card.setCardNumber(cardNumber);

                    cardDao.saveCreditCard(card);

                    System.out.println("Credit Card Generated Successfully!");
                    System.out.println("Card Number: " + cardNumber);

                    break;

                // VIEW CARD DETAILS
                case 3:

                    List<CreditCard> cards = cardDao.getAllCards();

                    for (CreditCard c : cards) {

                        System.out.println("----------------------");
                        System.out.println("Card ID: " + c.getCardId());
                        System.out.println("Card Number: " + c.getCardNumber());
                        System.out.println("Credit Limit: " + c.getCreditLimit());
                        System.out.println("Available Limit: " + c.getAvailableLimit());
                        System.out.println("Customer: " + c.getCustomer().getName());
                    }

                    break;

                // MAKE TRANSACTION
                case 4:

                    sc.nextLine();

                    System.out.print("Enter Card Number: ");
                    String cardNo = sc.nextLine();

                    System.out.print("Enter Merchant: ");
                    String merchant = sc.nextLine();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    Transcation t = new Transcation();

                    t.setCardNumber(cardNo);
                    t.setMerchant(merchant);
                    t.setAmount(amount);
                    t.setDate(LocalDate.now());

                    transactionDao.saveTransaction(t);

                    System.out.println("Transaction Successful!");

                    break;

                // VIEW TRANSACTIONS
                case 5:

                    List<Transcation> list = transactionDao.getAllTransactions();

                    for (Transcation tr : list) {

                        System.out.println("------------------");
                        System.out.println("Transaction ID: " + tr.getTransactionId());
                        System.out.println("Card Number: " + tr.getCardNumber());
                        System.out.println("Merchant: " + tr.getMerchant());
                        System.out.println("Amount: " + tr.getAmount());
                        System.out.println("Date: " + tr.getDate());
                    }

                    break;

                // GENERATE BILL
                case 6:

                    sc.nextLine();

                    System.out.print("Enter Card Number: ");
                    String billCard = sc.nextLine();

                    List<Transcation> transactions = transactionDao.getAllTransactions();

                    double total = 0;

                    for (Transcation t1 : transactions) {

                        if (t1.getCardNumber().equals(billCard)) {
                            total += t1.getAmount();
                        }
                    }

                    if (total == 0) {
                        System.out.println("No transactions found for this card.");
                        break;
                    }

                    Bill bill = new Bill();

                    bill.setCardNumber(billCard);
                    bill.setTotalAmount(total);
                    bill.setBillDate(LocalDate.now());
                    bill.setDueDate(LocalDate.now().plusDays(15));
                    bill.setPaid(false);

                    billDao.saveBill(bill);
                    System.out.println("\n===============================");
                    System.out.println("        MONTHLY BILL");
                    System.out.println("===============================");
                    System.out.println("Bill Id: "+bill.getBillId());
                    System.out.println("Card Number : " + bill.getCardNumber());
                    System.out.println("Total Amount: " + bill.getTotalAmount());
                    System.out.println("Bill Date   : " + bill.getBillDate());
                    System.out.println("Due Date    : " + bill.getDueDate());
                    System.out.println("===============================");

                    break;

                // PAY BILL
                case 7:

                    System.out.print("Enter Bill ID: ");
                    Long billId = sc.nextLong();

                    Bill b = billDao.getBill(billId);

                    if (b == null) {
                        System.out.println("Bill not found!");
                        break;
                    }

                    System.out.print("Enter Payment Amount: ");
                    double payAmount = sc.nextDouble();

                    Payment payment = new Payment();

                    payment.setBill(b);
                    payment.setAmount(payAmount);
                    payment.setPaymentDate(LocalDate.now());

                    paymentDao.savePayment(payment);

                    b.setPaid(true);
                    billDao.updateBill(b);

                    System.out.println("Payment Successful!");

                    break;

                case 8:

                    System.out.println("Thank You!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}