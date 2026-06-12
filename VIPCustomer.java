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
        out += " VIP Customer Name : " + super.getName();
        out += " VIP Customer Email : " + super.getEmail();

        return out;
    }

    @Override
    public double calculateTicketPrice() {
        // 120 for testing : event. ticketPrice
        return 120 * DISCOUNT;
    }
    
}
