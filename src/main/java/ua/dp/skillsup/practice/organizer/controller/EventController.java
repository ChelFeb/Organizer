package ua.dp.skillsup.practice.organizer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.dp.skillsup.practice.organizer.domain.Event;
import ua.dp.skillsup.practice.organizer.dto.EventDTO;
import ua.dp.skillsup.practice.organizer.exception.event.EventCreationException;
import ua.dp.skillsup.practice.organizer.service.EventService;
import ua.dp.skillsup.practice.organizer.service.UserService;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static ua.dp.skillsup.practice.organizer.util.Constants.*;

@Controller
@RequestMapping("/main/events")
public class EventController {

    @Autowired
    EventService eventService;

    @Autowired
    UserService userService;


    @RequestMapping(method = RequestMethod.GET)
    public String showEventsPage(ModelMap model) {
        model.put("eventDTO", new EventDTO());

        return EVENTS;
    }

    @RequestMapping(value = "/timeline", method = RequestMethod.GET)
    public String showEventTimeLinePage(ModelMap model) {
        Date startOfDay = new Date();
        startOfDay.setHours(0);
        startOfDay.setMinutes(0);
        Date endOfDay = new Date();
        endOfDay.setHours(23);
        endOfDay.setMinutes(59);

        List<Event> currentDay = eventService.getEventsForUserByDate(startOfDay, endOfDay, userService.getCurrentUser());
        model.addAttribute("eventsByDay", currentDay);
        return TIME_LINE;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addNewEvent(@Valid EventDTO eventDTO, BindingResult validationResult,
                              ModelMap model) {
        model.put("eventDTO", eventDTO);

        if (validationResult.hasErrors()) {
            System.err.println("        -         --    -   Problem");
            return EVENTS;
        }

        try {
            eventService.createEvent(eventDTO);
        } catch (EventCreationException e) {
            e.printStackTrace();
            return EVENTS;
        }

        return REDIRECT + MAIN_VIEW;
    }

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

}
