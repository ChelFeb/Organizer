package ua.dp.skillsup.practice.organizer.service;

import ua.dp.skillsup.practice.organizer.domain.Event;
import ua.dp.skillsup.practice.organizer.domain.User;
import ua.dp.skillsup.practice.organizer.dto.EventDTO;
import ua.dp.skillsup.practice.organizer.exception.event.EventCreationException;
import ua.dp.skillsup.practice.organizer.exception.event.GetUserEventsException;

import java.util.Date;
import java.util.List;

public interface EventService {

    void createEvent(EventDTO eventDTO) throws EventCreationException;
    List<Event> getEventsForUserByDate(Date startDate, Date endDate, User user);
    List<Event> getUserEvents() throws GetUserEventsException;

}
