public class Event {

    private int eventId;
    private String name;
    private double ticketPrice;
    private int noAvailableSeats;

    // no arg constructor
    public Event() {

    }

    // all arg constrctor
    public Event(int eventId, String name, double ticketPrice, int noAvailableSeats) {
        setEventId(eventId);
        setName(name);
        setTicketPrice(ticketPrice);
        setNoAvailableSeats(noAvailableSeats);
    }

    // getters & setters
    public int getEventId() {
        return this.eventId;
    }

    public String getName() {
        return this.name;
    }

    public double getTicketPrice() {
        return this.ticketPrice;
    }

    public int getNoAvailableSeats() {
        return this.noAvailableSeats;
    }

    private void setEventId(int eventId) {
        if (eventId <= 0) {
            throw new IllegalArgumentException("Event ID must be greater than 0");
        }
        this.eventId = eventId;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name.trim();
    }

    private void setTicketPrice(double ticketPrice) {
        if (ticketPrice < 0) {
            throw new IllegalArgumentException("Ticket price cannot be negative");
        }
        this.ticketPrice = ticketPrice;
    }

    private void setNoAvailableSeats(int noAvailableSeats) {
        if (noAvailableSeats < 0) {
            throw new IllegalArgumentException("Number of available seats cannot be negative");
        }
        this.noAvailableSeats = noAvailableSeats;
    }

    // toString()
    @Override
    public String toString() {
        String out = "";

        out += " Event ID: " + eventId;
        out += ", Name : " + name;
        out += ", Ticket Price (Rs.) : " + ticketPrice;
        out += ", No. Available Seats : " + noAvailableSeats;

        return out;
    }
}
