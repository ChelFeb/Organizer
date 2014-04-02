package ua.dp.skillsup.practice.organizer.dao;

import ua.dp.skillsup.practice.organizer.domain.Event;
import ua.dp.skillsup.practice.organizer.domain.User;

import java.util.Date;
import java.util.List;

/**
 * Interface for Event
 * Created by EVG
 */
public interface EventDAO {

    /**
     * Get Event by userId
     *
     * @param id identifier
     */
    Event getById(Integer id);

    /**
     * Get List of Events
     */
    List<Event> getAllEvents();

    /**
     * Create new Event
     *
     * @param event
     */
    void create(Event event);

    /**
     * Update Event parameters
     *
     *
     * @param event
     */
    void update(Event event);

    /**
     * Delete Event
     *
     *
     * @param event
     */
    void delete(Event event);

    /**
     * Delete Event by his Id
     *
     *
     * @param id
     */
    void deleteById(Integer id);

    /**
     * Get Lists of events between given dates for particular user
     *
     *
     * @param startDate
     * @param endDate
     * @param user
     */
    List<Event> getEventsForUserByDate(Date startDate, Date endDate, User user);

    /**
     * Get list of events by user userId
     *
     * @param user
     */
    List<Event> getUserEvents(User user);

}
