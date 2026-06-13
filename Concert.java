public class Concert extends Event{
    private String artistName;

    // no arg constructor
    public Concert(){

    }

    // all arg constructor
    public Concert(int eventId, String name, double ticketPrice, int noAvailableSeats, String artistName){
        super(eventId, name, ticketPrice, noAvailableSeats);
        setArtistName(artistName);
    }

    // getters & setters
    public String getArtistName(){
        return this.artistName;
    }

    public void setArtistName(String artistName){
        if (artistName == null || artistName.trim().isEmpty()) {
            throw new IllegalArgumentException("Artist name cannot be null or empty");
        }
        this.artistName = artistName.trim();
    }

    // toString()
    @Override
    public String toString(){
        String out = "";

        out += " Event ID: " + super.getEventId();
        out += ", Name : " + super.getName();
        out += ", Ticket Price (Rs.) : " + super.getTicketPrice();
        out += ", No. Available Seats : " + super.getNoAvailableSeats();
        out += ", Artist Name : " + artistName;

        return out;
    }
}
