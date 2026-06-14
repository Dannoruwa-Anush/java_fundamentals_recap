package model;
public class VIPCustomer extends Customer{

    private static final double DISCOUNT = 0.1;

    // constructor
    public VIPCustomer(int customerId, String name, String email){
        super(customerId, name, email);
    }

    // toString()
    @Override
    public String toString() {
        String out = "";
        out += " Customer ID: " + super.getCustomerId();
        out += ", VIP Customer Name : " + super.getName();
        out += ", VIP Customer Email : " + super.getEmail();
        out += ", Ticket Discount : " + DISCOUNT;

        return out;
    }

    @Override
    public double getDiscount() {
        return DISCOUNT;
    } 
}
