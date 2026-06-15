import java.util.Scanner;

import enums.BookingStatusEnum;
import exceptions.BookingNotFoundException;
import exceptions.CustomerNotFoundException;
import exceptions.EventSoldOutException;
import model.Booking;
import model.Concert;
import model.Customer;
import model.Event;
import model.RegularCustomer;
import model.VIPCustomer;
import model.Workshop;
import repository.BookingRepository;
import repository.CustomerRepository;
import repository.EventRepository;
import utils.EventUtil;
import utils.BookingMonitorUtil;
import utils.RepositoryUtil;

public class BookingDriver {
    public static void main(String[] args) {

        EventRepository eventRepo = new EventRepository();
        CustomerRepository customerRepo = new CustomerRepository();
        BookingRepository bookingRepo = new BookingRepository();

        // Booking monitor using threads
        BookingMonitorUtil bookingMonitor = new BookingMonitorUtil(eventRepo, bookingRepo);
        bookingMonitor.start();

        // Menu
        printMenu(eventRepo, customerRepo, bookingRepo);
    }

    public static void printMenu(EventRepository event, CustomerRepository customer, BookingRepository booking) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {

            System.out.println("\n========= EVENT TICKET BOOKING SYSTEM =========");
            System.out.println("1. Add Event");
            System.out.println("2. Register Customer");
            System.out.println("3. Book Tickets");
            System.out.println("4. Cancel Booking");
            System.out.println("5. View Events");
            System.out.println("6. View Bookings");
            System.out.println("7. Sort Events by Ticket Price");
            System.out.println("8. View Premium Events");
            System.out.println("9. Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    // Add Event

                    try{
                        System.out.print("Event Type [1] - Concert | [2] - Workshop : ");

                        int eventType = scanner.nextInt();

                        Event newEvent;

                        System.out.print("Enter Event ID: ");
                        int eventId  = scanner.nextInt();

                        System.out.print("Enter Event Name : ");
                        String eventName  = scanner.next();

                        System.out.print("Enter Ticket Price (Rs.) : ");
                        double ticketPrice  = scanner.nextDouble();

                        System.out.print("Enter No Available Seats : ");
                        int noAvailableSeats  = scanner.nextInt();

                        // concert
                        if(eventType == 1) {

                            System.out.print("Artist Name: ");
                            String artistName = scanner.next();

                            newEvent = new Concert(eventId, eventName, ticketPrice, noAvailableSeats, artistName);
                        }

                        //Workshop
                        else {
                            System.out.print("Trainer Name: ");
                            String trainerName = scanner.next();

                            newEvent = new Workshop(eventId, eventName, ticketPrice, noAvailableSeats, trainerName);
                        }

                        event.add(newEvent);
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("Invalid input: " + e.getMessage());
                    } 

                    break;

                case 2:
                    // Register Customer

                    try{
                        System.out.print("Customer Type: [1] - Regular | [2] - VIP : ");
                        int customerType = scanner.nextInt();
                        
                        Customer newCustomer;

                        System.out.print("Enter Customer ID: ");
                        int customerId  = scanner.nextInt();

                        System.out.print("Enter customer Name : ");
                        String customerName  = scanner.next();

                    System.out.print("Enter email : ");
                    String email = scanner.next();

                        // Regular customer
                        if(customerType == 1) {
                            newCustomer = new RegularCustomer(customerId, customerName, email);
                        }

                        // VIP customer
                        else {
                            newCustomer = new VIPCustomer(customerId, customerName, email);
                        }

                        customer.add(newCustomer);
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("Invalid input: " + e.getMessage());
                    } 

                    break;

                case 3:
                    // Book Tickets

                    try{
                        System.out.print("Enter Booking ID: ");
                        int bookingId = scanner.nextInt();

                        System.out.print("Enter Customer ID: ");
                        int customerIdForBooking = scanner.nextInt();

                        System.out.print("Enter Event ID: ");
                        int eventIdForBooking = scanner.nextInt();

                        System.out.print("Enter Number of Tickets: ");
                        int qty = scanner.nextInt();

                        // Find customer
                        Customer customerObj = customer.getById(customerIdForBooking);
                        if(customerObj == null) {
                            throw new CustomerNotFoundException("Customer not found");
                        }

                        // Find event
                        Event eventObj = event.getById(eventIdForBooking);
                        if(eventObj.getNoAvailableSeats() < qty) {
                            throw new EventSoldOutException("Not enough seats available");
                        }

                        // Ticket total calculation for customer
                        double customerTicketPrice = customerObj.calculateTicketPrice(eventObj.getTicketPrice());
                        // Calculate total
                        double totalAmount = customerTicketPrice * qty;

                        Booking newBooking = new Booking(bookingId, customerObj, eventObj, qty, totalAmount, BookingStatusEnum.COMPLETED);
                        newBooking.bookTicket();
                        booking.add(newBooking);
                    }
                    catch(CustomerNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    catch(EventSoldOutException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("Invalid input: " + e.getMessage());
                    }

                    break;

                case 4:
                    // Cancel Booking

                    try{
                        System.out.print("Enter Booking ID: ");
                        int bookingIdToCancel = scanner.nextInt();

                        Booking bookingObj = booking.getById(bookingIdToCancel);
                        if(bookingObj == null){
                            throw new BookingNotFoundException("Booking not found");
                        }
                        bookingObj.cancelTicket();
                    }
                    catch(BookingNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    catch(IllegalArgumentException e) {
                        System.out.println("Invalid input: " + e.getMessage());
                    }

                    break;

                case 5:
                    // View Events

                    RepositoryUtil.printRepo(event);
                    break;

                case 6:
                    // View Bookings

                    RepositoryUtil.printRepo(booking);
                    break;

                case 7:
                    // Sort Events by Ticket Price

                    EventUtil.sortByTicketPrice(event);
                    break;

                case 8:
                    // View Premium Events

                    EventUtil.viewPremiumEvents(event);
                    break;

                case 9:
                    // Exit

                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 9);
    }
}