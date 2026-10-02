package billing.system;

import java.util.ArrayList;
import java.util.Scanner;

public class BillingSystem{
        ArrayList<Product>products=new ArrayList<>();
        ArrayList<Customer>customers=new ArrayList<>();
        private Scanner sc=new Scanner(System.in);
        //add product
    public void addProduct(){
        System.out.println("enter product id:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("enter product name:");
        String name= sc.nextLine();
        System.out.println("enter product price:");
        double price=sc.nextDouble();
        System.out.println("enter quantity:");
        int quantiy=sc.nextInt();
        Product product=new Product(id,name,price,quantiy);
        products.add(product);
        System.out.println("product added successfully!");
    }
    //display products
    public void displayProducts(){
        System.out.println("***********product list***********");
        for(Product product:products){
            product.displayProduct();
        }
    }
    //add customer
    public void addCustomer(){
        System.out.println("enter customer id:");
        int id=sc.nextInt();
        sc.nextLine();
        System.out.println("enter customer name:");
        String name=sc.nextLine();
        System.out.println("enter customer phone number");
        String phone=sc.nextLine();
        Customer customer=new Customer(id,name,phone);
        customers.add(customer);
    }
    //display customer
    public void displayCustomer(){
        System.out.println("******customer list**********");
        for(Customer customer:customers){
            customer.displayCustomer();
        }
    }
    //search Product
    public void serchProduct(){
        System.out.println("enter product id to search");
        int id=sc.nextInt();
        for(Product product:products){
            if(product.getProductId()==id){
                System.out.println("\nproduct found");
                product.displayProduct();
                return;
            }
        }
        System.out.println("product not found");
    }
    //remove product
    public void removeProduct(){
        System.out.println("enter product id to remove");
        int id=sc.nextInt();
        for(Product product:products){
            if(product.getProductId()==id){
                products.remove(product);
                System.out.println("product removed suceesessfully");
                return;
            }
        }
        System.out.println("product not found");
    }
    //update product quantity
    public void updateProductQuantity(){
        System.out.println("enter product id:");
        int id= sc.nextInt();
        System.out.println("enter new quantity:");
        int newQuantity=sc.nextInt();
        for(Product product:products){
            if(product.getProductId()==id){
                product.setQuantity(newQuantity);
                System.out.println("product quantity updated successfully!");
                return;
            }
        }
        System.out.println("product not found");
    }
    //add product to bill
    public void addProductToBill(Bill bill){
        System.out.print("enter product id:");
        int id=sc.nextInt();
        System.out.println("enter quantity");
        int quantity=sc.nextInt();
        for(Product product:products){
            if(product.getProductId()==id){
                if(quantity<=product.getQuantity()){
                    BillItem item=new BillItem(product,quantity);
                    bill.additem(item);
                    product.setQuantity(product.getQuantity()-quantity);
                    System.out.println("product add successfulyy!");
                }
                else{
                    System.out.println("insufficient stock!");
                }
                return;
            }
        }
        System.out.println("product not found");
    }
}
