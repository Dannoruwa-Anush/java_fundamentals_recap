import java.util.Iterator;

import enums.BookingStatusEnum;
import repository.Repository;

public class BookingDriver{
    public static void main (String[] args){
        Repository<Event> eventRepoRef = new Repository<>();
        
        Concert concertRef1 = new Concert(1, "Padura", 5000, 1000, "Ridma");
        eventRepoRef.add(concertRef1);  
        Concert concertRef2 = new Concert(2, "31st night", 15000, 10, "Jinger");
        eventRepoRef.add(concertRef2);
        
        printRepo(eventRepoRef);



        Repository<RegularCustomer> regularCusRepoRef = new Repository<>();
        
        RegularCustomer regularCusRef = new RegularCustomer(1, "test", "test@gmail.com");
        regularCusRef.calculateTicketPrice(120);
        regularCusRepoRef.add(regularCusRef);
        
        printRepo(regularCusRepoRef);

        Repository<Booking> bookingRepoRef = new Repository<>();
        
        Booking bookingRef = new Booking(1, regularCusRef, concertRef1, 1, BookingStatusEnum.COMPLETED);
        bookingRepoRef.add(bookingRef);

        printRepo(bookingRepoRef);
    }

    public static <T> void printRepo(Repository<T> repo) {
        Iterator<T> iterator = repo.getAll().iterator();

        while (iterator.hasNext()) {
            T item = iterator.next();
            System.out.println(item);
        }
    }
}