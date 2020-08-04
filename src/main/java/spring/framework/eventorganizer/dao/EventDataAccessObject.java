package spring.framework.eventorganizer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import spring.framework.eventorganizer.model.Event;
import spring.framework.eventorganizer.repository.EventRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDataAccessObject {

    // need a place to put events
    // private static final Map<Long, Event> events = new HashMap<>();
    @Autowired // connection to db
    private static EventRepository eventRepository;

    // get all events
    public static List<Event> getAllEvents() {
        List<Event> events = eventRepository.findAll(); // getting data from db
        return events;
    }

    // get a single event
    public static Event getEventById(Long id) {
        return eventRepository.getOne(id);
    }

    // add an event
    public static void createEvent(Event event) {
        eventRepository.save(event);
    }

    // remove an event
    public static void deleteEventById(Long id) {
        eventRepository.deleteById(id); // TODO double-check its implementation
    }
}
