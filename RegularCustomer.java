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
        out += " Regular Customer Name : " + super.getName();
        out += " Regular Customer Email : " + super.getEmail();

        return out;
    }

    @Override
    public double calculateTicketPrice() {
        // 120 for testing : event. ticketPrice
        return 120 * DISCOUNT;
    }
}
