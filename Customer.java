package billing.system;

public class Customer {
    private int customerId;
    private String customerName;
    private String phoneNumber;
    public Customer(int customerId, String customerName, String phoneNumber) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }public void displayCustomer(){
        System.out.println("customer id:"+customerId);
        System.out.println("customer name:"+customerName);
        System.out.println("phone number:"+phoneNumber);
    }
}
