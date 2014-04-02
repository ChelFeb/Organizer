package ua.dp.skillsup.practice.organizer.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ua.dp.skillsup.practice.organizer.dao.EventDAO;
import ua.dp.skillsup.practice.organizer.domain.Event;
import ua.dp.skillsup.practice.organizer.domain.User;
import ua.dp.skillsup.practice.organizer.dto.EventDTO;
import ua.dp.skillsup.practice.organizer.exception.event.EventCreationException;
import ua.dp.skillsup.practice.organizer.exception.event.GetUserEventsException;
import ua.dp.skillsup.practice.organizer.service.UserService;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by Shaman on 24.03.2014.
 */
@RunWith(MockitoJUnitRunner.class)
public class EventServiceImplTest {

    @Mock
    EventDTO eventDTO;

    @Mock
    Event event;

    @Mock
    List<Event> events;

    @Mock
    User user;

    @Mock
    UserService userService;

    @Mock
    EventDAO eventDAO;

    @InjectMocks
    EventServiceImpl eventService;


    @Test
    public void testGetAllEvents() throws GetUserEventsException {
        when(userService.getCurrentUser()).thenReturn(user);
        eventService.getUserEvents();
        verify(eventDAO).getUserEvents(user);
    }

}
