package billing.system;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;
    public Product(int productId,String productName,double price,int quantity){
        this.productId=productId;
        this.productName=productName;
        this.price=price;
        this.quantity=quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void displayProduct(){
        System.out.println("product id:"+productId);
        System.out.println("product name:"+productName);
        System.out.println("price:"+price);
        System.out.println("quantity:"+quantity);
    }
}
