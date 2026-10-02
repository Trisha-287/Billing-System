package billing.system;

import java.util.ArrayList;

public class Bill {
    Customer customer;
    ArrayList<BillItem>items;
    double subtotal;
    double discount;
    double totalamount;
double gst;
    public Bill(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }
    public void additem(BillItem item){
        items.add(item);
    }
    public Customer getCustomer() {

        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<BillItem> getItems() {
        return items;
    }

    public void setItems(ArrayList<BillItem> items) {
        this.items = items;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalamount() {
        return totalamount;
    }

    public void setTotalamount(double totalamount) {
        this.totalamount = totalamount;
    }

    public double getGst() {
        return gst;
    }

    public void setGst(double gst) {
        this.gst = gst;
    }

    public double calculateSubtotal(){
        subtotal=0;
        for(BillItem item:items){
            subtotal+=item.getTotalprice();
        }
        return subtotal;
    }
    public double calculateDiscount(){
        if(subtotal>=5000){
            discount=subtotal*10/100;
        }
        else if(subtotal>=2000){
            discount=subtotal*5/100;
        }
        else{
            discount=0;
        }
        return  discount;
    }
    public double calculateGst(){
        double amountAfterDiscount=subtotal-discount;
        gst=amountAfterDiscount*18/100;
        return gst;
    }
    public double calculateTotal(){
        totalamount=subtotal-discount+gst;
        return totalamount;
    }
    public void displayBill(){
     System.out.println("*******bil************");
     customer.displayCustomer();
     for(BillItem item:items){
         item.displayItem();
     }
        System.out.println("subtotal:"+subtotal);
        System.out.println("dicount:"+discount);
        System.out.println("Gst:"+gst);
        System.out.println("totalamount:"+totalamount);
    }
}
