package ua.dp.skillsup.practice.organizer.dao;

import ua.dp.skillsup.practice.organizer.domain.*;

import java.util.Date;
import java.util.List;

public interface UserDAO {

    /**
     * Get User by id
     *
     * @param id identifier
     */
    User getById(Integer id);

    /**
     * Get User by email
     *
     * @param email identifier
     */
    User getByEmail(String email);

    /**
     * Get List of Users
     */
    List<User> getAllUsers();

    /**
     * Create new User
     *
     * @param user
     */
    void create(User user);

    /**
     *
     * @param email    by user
     * @param password by user
     */
    void create(String email, String password, Date date);

    /**
     * Update User parameters
     *
     *
     * @param user
     */
    void update(User user);

    /**
     * Delete User
     *
     *
     * @param user
     */
    void delete(User user);

    /**
     * Delete User by his Id
     *
     *
     * @param id
     */
    void deleteById(Integer id);


}
