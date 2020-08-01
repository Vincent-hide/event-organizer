package spring.framework.eventorganizer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    @GetMapping
    public String displayAllEvents(Model model) {
        List<String> events = new ArrayList<>();
        events.add("Item 1");
        events.add("Item 2");
        events.add("Item 3");
        events.add("Item 4");
        model.addAttribute("events", events); // passing an array list to events/index.html
        return "events/index";
    }

    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }
}
