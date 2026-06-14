package model;
public class Workshop extends Event{
    private String trainerName;

    // no arg constructor
    public Workshop(){

    }

    // all arg constructor
    public Workshop(int eventId, String name, double ticketPrice, int noAvailableSeats, String trainerName){
        super(eventId, name, ticketPrice, noAvailableSeats);
        setTrainerName(trainerName);
    }

    // getters & setters
    public String getTrainerName(){
        return this.trainerName;
    }

    public void setTrainerName(String trainerName){
        if (trainerName == null || trainerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Trainer name cannot be null or empty");
        }

        this.trainerName = trainerName;
    }

    // toString()
    @Override
    public String toString(){
        String out = "";

        out += " Event ID: " + super.getEventId();
        out += ", Name : " + super.getName();
        out += ", Ticket Price (Rs.) : " + super.getTicketPrice();
        out += ", No. Available Seats : " + super.getNoAvailableSeats();
        out += ", Trainer Name : " + trainerName;

        return out;
    }
}
