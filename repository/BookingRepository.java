package repository;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

import model.Booking;

public class BookingRepository implements IRepository<Booking>{

    private Queue<Booking> bookings;

    // no arg constrctor
    public BookingRepository(){
        bookings = new LinkedList<>(); // polymorphism via an interface
    }

    @Override
    public void add(Booking booking) {
        bookings.offer(booking);
    }

    @Override
    public void remove(Booking booking) {
        bookings.remove(booking);
    }

    @Override
    public Collection<Booking> getAll() {
        return bookings;
    }
    
    // unique methods

    public Booking getNextBooking() {
        return bookings.poll();
    }
}
