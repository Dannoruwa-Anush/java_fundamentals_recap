public class RegularCustomer extends Customer{

    private static final double DISCOUNT = 0.0;

    // constructor
    public RegularCustomer(int customerId, String name, String email){
        super(customerId, name, email);
    }

    // toString()
    @Override
    public String toString() {
        String out = "";
        out += " Customer ID: " + super.getCustomerId();
        out += ", Regular Customer Name : " + super.getName();
        out += ", Regular Customer Email : " + super.getEmail();
        out += ", Ticket Discount : " + DISCOUNT;

        return out;
    }

    @Override
    public double getDiscount() {
        return DISCOUNT;
    }
}
