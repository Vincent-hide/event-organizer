package spring.framework.eventorganizer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.framework.eventorganizer.model.Event;
import spring.framework.eventorganizer.repository.EventRepository;

import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    moved to dao/EventDataAccessObject
//    @Autowired // connection to db
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping({"/", "/home"}) // localhost:8080 or localhost/events/home
    public String displayAllEvents(Model model) {
        List<Event> events = this.eventRepository.findAll(); // getting data from db
        model.addAttribute("events", events); // passing an array list to events/index.html
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

    @PostMapping("create")
    public String createEvent(@RequestParam String title, @RequestParam String description) {
        this.eventRepository.save(new Event(title, description)); // saving into db
        return "redirect:/events/home"; // redirecting to displayAllEvents
    }

}
