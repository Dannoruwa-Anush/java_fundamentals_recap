package utils;

import model.Booking;
import model.Event;
import repository.IRepository;

public class BookingMonitorUtil extends Thread{
    private IRepository<Event> eventRepo;
    private IRepository<Booking> bookingRepo;

    // all arg constrctor
    public BookingMonitorUtil(IRepository<Event> eventRepo, IRepository<Booking> bookingRepo) {
        this.eventRepo = eventRepo;
        this.bookingRepo = bookingRepo;
    }

    @Override
    public void run() {

        while(true) {

            System.out.println("\n===== Booking Monitor =====");
            System.out.println("Available Events : " + eventRepo.getAll().size());
            System.out.println("Active Bookings : " + bookingRepo.getAll().size());
            System.out.println( "===========================");

            try {

                Thread.sleep(60000);

            } catch (InterruptedException e) {

                System.out.println("Monitor Interrupted");
            }
        }
    }
}
