package ua.dp.skillsup.practice.organizer.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.dp.skillsup.practice.IntegrationTest;
import ua.dp.skillsup.practice.organizer.dao.EventDAO;
import ua.dp.skillsup.practice.organizer.dao.UserDAO;
import ua.dp.skillsup.practice.organizer.domain.Event;
import ua.dp.skillsup.practice.organizer.domain.User;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by jack
 */
public class EventDAOimplTest extends IntegrationTest {

    @Autowired
    private EventDAO eventDAO;

    @Autowired
    private UserDAO userDAO;

    private SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm");

    @Before
    public void initial() {
        initializeData();
    }

    @Test
    public void testGetById() throws Exception {
        Event event = eventDAO.getById(1);
        assertEquals("example", event.getSubject());
    }


    @Test
    public void testDelete() throws Exception {
        Event event = eventDAO.getById(1);
        eventDAO.delete(event);
        assertEquals(3, eventDAO.getAllEvents().size());
    }

    @Test
    public void testUpdate() throws Exception {
        Event event = eventDAO.getById(1);
        event.setSubject("subject");
        eventDAO.update(event);
        assertEquals(event, eventDAO.getById(1));
    }

    @Test
    public void testCreate() throws Exception{
        Event event = new Event();
        event.setSubject("testSubject");
        event.setDescription("testDescription");
        eventDAO.create(event);
        assertEquals(Integer.valueOf(6), event.getId());
        assertEquals("testSubject", eventDAO.getById(6).getSubject());
        assertEquals("testDescription", eventDAO.getById(6).getDescription());
    }

    @Test
    public void testGetAllEvents() throws Exception {
        List<Event> events = eventDAO.getAllEvents();
        assertEquals(4, events.size());
        assertEquals("example", events.get(0).getSubject());
        assertEquals("example2", events.get(1).getSubject());
        assertEquals("example", events.get(0).getDescription());
        assertEquals("example2", events.get(1).getDescription());
    }

    @Test
    public void testGetUsersEvents() throws Exception {
        User user = userDAO.getById(1);
        List<Event> events = eventDAO.getUserEvents(user);
        assertEquals(user, userDAO.getByEmail("test1@test.com"));
        assertEquals(1, events.size());
    }

    @Test
    public void testGetEventsBetweenDates() throws Exception {
        Date startDate = dateFormatter.parse("2014-03-02 12:25");
        Date endDate = dateFormatter.parse("2014-03-06 23:30");
        User user = userDAO.getById(2);
        List<Event> events = eventDAO.getEventsForUserByDate(startDate, endDate, user);
        assertEquals(2, events.size());
        assertEquals(events.get(0).getSubject(), "betweenDates");
        assertEquals(events.get(0).getDescription(), "betweenDatesTest");
        assertEquals(events.get(1).getSubject(), "dateAndTime");
        assertEquals(events.get(1).getDescription(), "dateAndTimeTest");
    }

    @Test
    public void testGetEventsBetweenDatesAndTime() throws Exception {
        Date startDate = dateFormatter.parse("2014-03-05 13:00");
        Date endDate = dateFormatter.parse("2014-03-05 17:15");
        User user = userDAO.getById(2);
        List<Event> events = eventDAO.getEventsForUserByDate(startDate, endDate, user);
        assertEquals(1, events.size());
        assertEquals(events.get(0).getSubject(), "dateAndTime");
        assertEquals(events.get(0).getDescription(), "dateAndTimeTest");
    }

}
