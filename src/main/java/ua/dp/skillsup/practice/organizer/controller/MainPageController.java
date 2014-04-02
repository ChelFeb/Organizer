package ua.dp.skillsup.practice.organizer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.dp.skillsup.practice.organizer.domain.Event;
import ua.dp.skillsup.practice.organizer.domain.User;
import ua.dp.skillsup.practice.organizer.exception.event.GetUserEventsException;
import ua.dp.skillsup.practice.organizer.service.EventService;
import ua.dp.skillsup.practice.organizer.service.UserService;

import java.util.List;

import static ua.dp.skillsup.practice.organizer.util.Constants.MAIN_VIEW;

/**
 * Controller for viewing main page
 *
 */
@Controller
@RequestMapping(value = "/main")
public class MainPageController {

    @Autowired
    UserService userService;

    @Autowired
    EventService eventService;

    private static final Logger LOG = LoggerFactory.getLogger(MainPageController.class);

    @RequestMapping
    public String showMain(ModelMap model) {
        final User user = userService.getCurrentUser();
        model.put("message", "Greetings " + user.getEmail());
        model.put("userEvents", getEvents());
        return MAIN_VIEW;
    }

    private List<Event> getEvents() {
        List<Event> list = null;
        try {
            list = eventService.getUserEvents();
        } catch (GetUserEventsException e) {
            LOG.info("Error getting user events", e.getMessage());
        }
        return list;
    }
}
