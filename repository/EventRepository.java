package repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import model.Event;

public class EventRepository implements IRepository<Event>{

    private List<Event> events;

    // no arg constrctor
    public EventRepository(){
        events = new ArrayList<>(); // polymorphism via an interface
    }

    @Override
    public void add(Event event) {
        events.add(event);
    }

    @Override
    public void remove(Event event) {
       events.remove(event);
    }

    @Override
    public Collection<Event> getAll() {
        return events;
    }
}
