import enums.BookingStatusEnum;

public class Booking {
    private int bookingId;
    private Customer customer;
    private Event event;
    private int noTickets;
    private BookingStatusEnum bookingStatus;

    // no arg constructor
    public Booking(){

    }

    // constructor
    public Booking(int bookingId, Customer customer, Event event, int noTickets, BookingStatusEnum bookingStatus){
        setBookingId(bookingId);
        setCustomer(customer);
        setEvent(event);
        setNoTickets(noTickets);
        setBookingStatus(bookingStatus);
    }

    // getters & setters
    public int getBookingId(){
        return this.bookingId;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public Event getEvent(){
        return this.event;
    }

    public int getNoTickets(){
        return this.noTickets;
    }

    public BookingStatusEnum getBookingStatus(){
        return this.bookingStatus;
    }

    public void setBookingId(int bookingId) {
        if (bookingId <= 0) {
            throw new IllegalArgumentException("Booking ID must be greater than 0");
        }
        this.bookingId = bookingId;
    }

    public void setCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }
        this.customer = customer;
    }

    public void setEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null");
        }
        this.event = event;
    }

    public void setNoTickets(int noTickets) {
        if (noTickets <= 0) {
            throw new IllegalArgumentException("Number of tickets must be greater than 0");
        }
        this.noTickets = noTickets;
    }

    public void setBookingStatus(BookingStatusEnum bookingStatus) {
        if (bookingStatus == null) {
            throw new IllegalArgumentException("Booking status cannot be null");
        }
        this.bookingStatus = bookingStatus;
    }

    // toString()
    @Override
    public String toString() {
        String out = "";
        out += " Booking ID: " + bookingId;
        out += ", Customer : " + customer.toString();
        out += ", Event : " + event.toString();
        out += ", No Tickets : " + noTickets;
        out += ", Booking Status : " + bookingStatus.getDisplayName();

        return out;
    }
}
