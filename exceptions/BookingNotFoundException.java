package exceptions;

public class BookingNotFoundException extends Exception{
    
    // Constructor
    public BookingNotFoundException(String message){
        super(message);
    }
}
