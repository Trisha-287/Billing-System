package billing.system;

import java.util.ArrayList;
import java.util.Scanner;

public class BillingSystem {
    ArrayList<Product> products = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<String> transactionHistory = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    Bill currentBill;

    //Add Product
    public void addProduct() {
        try {
            System.out.println("enter product id:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("enter product name:");
            String name = sc.nextLine();
            System.out.println("enter product price:");
            double price = sc.nextDouble();
            System.out.println("enter quantity:");
            int quantiy = sc.nextInt();
            if (price < 0 || quantiy < 0) {
                System.out.println("price and quantiy cannot be negarive");
                return;
            }
            Product product = new Product(id, name, price, quantiy);
            products.add(product);
            System.out.println("product added successfully!");
        } catch (Exception e) {
            System.out.println("invalid input");
            sc.nextLine();
        }
    }

    //display products
    public void displayProducts() {
        System.out.println("***********product list***********");
        if (products.isEmpty()) {
            System.out.println("no product is available");
            return;
        }
        for (Product product : products) {
            product.displayProduct();
        }
    }

    //add customer
    public void addCustomer() {
        try {
            System.out.println("enter customer id:");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("enter customer name:");
            String name = sc.nextLine();
            System.out.println("enter customer phone number");
            String phone = sc.nextLine();
            Customer customer = new Customer(id, name, phone);
            customers.add(customer);
            System.out.println("customer added succesfully!");
        } catch (Exception e) {
            System.out.println("invalid input");
            sc.nextLine();
        }
    }

    //display customer
    public void displayCustomer() {
        System.out.println("******customer list**********");
        if (customers.isEmpty()) {
            System.out.println("no customer available");
            return;
        }
        for (Customer customer : customers) {
            customer.displayCustomer();
        }
    }

    //find customer
    public Customer findCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == id) {
                return customer;
            }
        }
       return null;
    }
    //search Product

    public void serchProduct() {
        System.out.println("enter product id to search");
        int id = sc.nextInt();
        for (Product product : products) {
            if (product.getProductId() == id) {
                System.out.println("\nproduct found");
                product.displayProduct();
                return;
            }
        }
        System.out.println("product not found");
    }

    //remove product
    public void removeProduct() {
        System.out.println("enter product id to remove");
        int id = sc.nextInt();
        for (Product product : products) {
            if (product.getProductId() == id) {
                products.remove(product);
                System.out.println("product removed suceesessfully");
                return;
            }
        }
        System.out.println("product not found");
    }

    //update product quantity
    public void updateProductQuantity() {
        System.out.println("enter product id:");
        int id = sc.nextInt();
        System.out.println("enter new quantity:");
        int newQuantity = sc.nextInt();
        for (Product product : products) {
            if (product.getProductId() == id) {
                product.setQuantity(newQuantity);
                System.out.println("product quantity updated successfully!");
                return;
            }
        }
        System.out.println("product not found");
    }
    //subtotal
    public void calculateSubtotal(){
        if (currentBill == null) {
            System.out.println("please generate a bill first");
            return;
        }
        double subtotal=currentBill.calculateSubtotal();
        System.out.println("sub total:"+subtotal);
    }

    //discount
    public void applyDiscount() {
        if (currentBill == null) {
            System.out.println("please generate a bill first");
            return;
        }
        currentBill.calculateSubtotal();
        double discuont=  currentBill.calculateDiscount();
        System.out.println("Discount:"+discuont);
    }
    //gst
    public void calculateGst(){
     if(currentBill==null){
        System.out.println("please generate a bill first");
        return;
    }
        currentBill.calculateSubtotal();
        currentBill.calculateDiscount();
        double gst=  currentBill.calculateGst();
        System.out.println("gst:"+gst);
}

    //bdisplay bill
    public void displayBill() {
        if(currentBill==null){
            System.out.println ("please generate a bill first");
            return;
        }
        currentBill.calculateSubtotal();
        currentBill.calculateDiscount();
        currentBill.calculateGst();
        currentBill.calculateTotal();
    }

    //payement
    public void processPayment() {
        if(currentBill==null){
            System.out.println("please generate a bill first");
            return;
        }
        currentBill.calculateSubtotal();
        currentBill.calculateDiscount();
        currentBill.calculateGst();
        currentBill.calculateTotal();
        double totalAmount = currentBill.getTotalamount();
        System.out.println("***payment**********");
        System.out.println("Total Amount:" + totalAmount);
        System.out.println("enter payement amount");
        double payment = sc.nextDouble();
        if (payment < totalAmount) {
            System.out.println("insufficient payement");
            return;
        } else {
            double change = payment - totalAmount;
            System.out.println("payement successfull:");
            System.out.println("paid amount:" + payment);
            System.out.println("change:" + change);
        }
    }//receipt
    public void generateReceipt() {
        System.out.println("==========receipt=========");
        if(currentBill==null){
            System.out.println("please generate a bill first.");
            return;
        }
        currentBill.calculateSubtotal();
        currentBill.calculateTotal();
        currentBill.calculateDiscount();
        currentBill.calculateGst();
        System.out.println("customer name:" + currentBill.getCustomer().getCustomerName());
        System.out.println("phone:" + currentBill.getCustomer().getPhoneNumber());
        System.out.println("subtotal:" +currentBill.getSubtotal());
        System.out.println("discount:" + currentBill.getDiscount());
        System.out.println("gst:" + currentBill.getDiscount());
        System.out.println("total amount:" + currentBill.getTotalamount());
        System.out.println("payement status paid");
        System.out.println("thank you for shopping");
    }

    //transaction history
    public void addTransaction() {
        if (transactionHistory.isEmpty()) {
            System.out.println("no transaction available");
            return;
            System.out.println("*******transaxtion history*****");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
        public void start () {
            int choice;
            do {
                System.out.println("******billing system***");
                System.out.println("1.add product");
                System.out.println("2.display product");
                System.out.println("3.search product");
                System.out.println("4.remove product");
                System.out.println("5.update product quantity");
                System.out.println("6.add customer");
                System.out.println("7.display customer");
                System.out.println("8.generate bill");
                System.out.println("9.calculate subtotal");
                System.out.println("10. apply discount");
                System.out.println("11.calculate gst");
                System.out.println("12.display bill");
                System.out.println("13.payement");
                System.out.println("14.receipt");
                System.out.println("15.transaction history");
                System.out.println("16.exit");
                System.out.print("enter your choice:");
                try {
                    choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            addProduct();
                            break;
                        case 2:
                            displayProducts();
                            break;
                        case 3:
                            serchProduct();
                            break;
                        case 4:
                            removeProduct();
                            break;
                        case 5:
                            updateProductQuantity();
                            break;
                        case 6:
                            addCustomer();
                            break;
                        case 7:
                            displayCustomer();
                            break;
                        case 8:
                            System.out.println("");
                            break;
                        case 9:
                            calculateSubtotal();
                            break;
                        case 10:
                            applyDiscount();
                            break;
                        case 11:
                            calculateGst();
                            break;
                        case 12:
                            displayBill();
                            break;
                        case 13:
                            processPayment();
                            break;
                        case 14:
                            generateReceipt();
                            break;
                        case 15:
                            addTransaction();
                        case 16:
                            System.out.println("thank you for using billing");
                            break;
                        default:
                            System.out.println("invalid choice");
                    }
                } catch (Exception e) {
                    System.out.println("please enter a valid number");
                    sc.nextLine();
                    choice = 0;
                }
            } while (choice != 16);
        }
        public static void main (String[]args){
            BillingSystem system = new BillingSystem();
            system.start();
        }
    }

