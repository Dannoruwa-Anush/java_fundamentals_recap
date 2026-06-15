package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Event;
import repository.EventRepository;
import repository.IRepository;

public class EventUtil {

    public static void sortByTicketPrice(EventRepository repo) {
        List<Event> events = new ArrayList<>(repo.getAll());

        if (events.isEmpty()) {
            System.out.println("No events available to sort.");
            return;
        }

        // Lambda Expressions: represent a function without a name
        events.sort(
                (e1, e2) -> Double.compare(
                        e2.getTicketPrice(),
                        e1.getTicketPrice()));

        System.out.println("\nSorted Events:");

        for (Event event : events) {
            System.out.println(event);
        }
    }

    public static void viewPremiumEvents(IRepository<Event> eventRepo) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter minimum ticket price: ");
        double amount = input.nextDouble();

        // Stream API
        var premiumEvents = eventRepo.getAll()
                .stream()
                .filter(event -> event.getTicketPrice() > amount)
                .toList();

        if (premiumEvents.isEmpty()) {
            System.out.println("No events found with ticket price greater than Rs. " + amount);

            return;
        }

        System.out.println("\nPremium Events:");

        premiumEvents.forEach(System.out::println);
    }
}
