import java.util.Iterator;
import enums.BookingStatusEnum;
import model.Booking;
import model.Concert;
import model.RegularCustomer;
import repository.BookingRepository;
import repository.CustomerRepository;
import repository.EventRepository;
import repository.IRepository;

public class BookingDriver{
    public static void main (String[] args){
        
        // Add Event
        EventRepository eventRepo = new EventRepository();
        Concert concert1 = new Concert(1, "Padura", 5000, 1000, "Ridma");
        eventRepo.add(concert1);  
        Concert concert2 = new Concert(2, "31st night", 15000, 10, "Jinger");
        eventRepo.add(concert2);
        
        printRepo(eventRepo);


        // Add Customer
        CustomerRepository customerRepo = new CustomerRepository();
        RegularCustomer regularCus1 = new RegularCustomer(1, "test", "test@gmail.com");
        regularCus1.calculateTicketPrice(120);
        customerRepo.add(regularCus1);
        
        printRepo(customerRepo);

        // Add Booking
        BookingRepository bookingRepo = new BookingRepository();
        Booking booking1 = new Booking(1, regularCus1, concert1, 1, BookingStatusEnum.COMPLETED);
        bookingRepo.add(booking1);
        printRepo(bookingRepo);
    }

    public static <T> void printRepo(IRepository<T> repo) {
        Iterator<T> iterator = repo.getAll().iterator();

        while (iterator.hasNext()) {
            T item = iterator.next();
            System.out.println(item);
        }
    }
}