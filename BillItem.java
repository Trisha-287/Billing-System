package billing.system;

public class BillItem {
     Product product;
     int quantity;
    double totalprice;
    public BillItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.totalprice = product.getPrice()*quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
    public void displayItem(){
        System.out.println("productName:"+product.getProductName());
        System.out.println("Quantity:"+quantity)  ;
        System.out.println("Total price:"+totalprice);
    }
}
