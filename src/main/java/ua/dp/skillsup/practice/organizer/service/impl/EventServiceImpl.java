package ua.dp.skillsup.practice.organizer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.skillsup.practice.organizer.dao.EventDAO;
import ua.dp.skillsup.practice.organizer.domain.Event;
import ua.dp.skillsup.practice.organizer.domain.EventType;
import ua.dp.skillsup.practice.organizer.domain.User;
import ua.dp.skillsup.practice.organizer.dto.EventDTO;
import ua.dp.skillsup.practice.organizer.exception.event.EventCreationException;
import ua.dp.skillsup.practice.organizer.exception.event.GetUserEventsException;
import ua.dp.skillsup.practice.organizer.service.EventService;
import ua.dp.skillsup.practice.organizer.service.UserService;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    EventDAO eventDAO;

    @Autowired
    UserService userService;

    @Override
    @Transactional
    public void createEvent(final EventDTO eventDTO) throws EventCreationException {
        try {
            Event event = new Event();
            event.setSubject(eventDTO.getSubject());
            event.setDescription(eventDTO.getDescription());
            event.setOwnerId(userService.getCurrentUser());
            event.setDateStart(eventDTO.getStartDate());
            event.setDateEnd(eventDTO.getEndDate());
            event.setDeadLine(eventDTO.getDeadline());
            event.setType(EventType.getTypeByCaption(eventDTO.getType()));
            event.setDone(false);
            eventDAO.create(event);
        } catch (Exception e) {
            throw new EventCreationException(e);
        }

    }

    @Transactional(readOnly = true)
    public List<Event> getEventsForUserByDate(Date startDate, Date endDate, User user) {
        return eventDAO.getEventsForUserByDate(startDate, endDate, user);
    }

    @Override
    @Transactional
    public List<Event> getUserEvents() throws GetUserEventsException {
        try {
            return eventDAO.getUserEvents(userService.getCurrentUser());
        } catch (Exception e) {
            throw new GetUserEventsException(e);
        }

    }
}
