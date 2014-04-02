package ua.dp.skillsup.practice.organizer.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ua.dp.skillsup.practice.IntegrationTest;
import ua.dp.skillsup.practice.organizer.dao.RoleDAO;
import ua.dp.skillsup.practice.organizer.dao.UserDAO;
import ua.dp.skillsup.practice.organizer.domain.Role;
import ua.dp.skillsup.practice.organizer.domain.User;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class UserDAOimplTest extends IntegrationTest {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Before
    public void initial() {
       initializeData();
    }

    @Test
    public void testGetAllUsers() throws Exception {
        assertEquals(2, userDAO.getAllUsers().size());
    }

    @Test
    public void testDeleteById() throws Exception {
        userDAO.deleteById(1);
        assertNull(userDAO.getById(1));
    }

    @Test
    public void testDelete() throws Exception {
        User user = userDAO.getById(1);
        userDAO.delete(user);
        User userNew = userDAO.getById(1);
        assertNull(userNew);
    }

    @Test
    public void testUpdate() throws Exception {
        User user = userDAO.getById(1);
        user.setEmail("myemail@test.t");
        userDAO.update(user);
        assertEquals("myemail@test.t", userDAO.getById(1).getEmail());
    }

    @Test
    public void testGetByEmail() {
        User user = userDAO.getByEmail("test1@test.com");
        assertEquals("test1@test.com", user.getEmail());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testGetById() throws Exception {
        User user = userDAO.getById(1);
        assertEquals("test1@test.com", user.getEmail());
    }

    @Test
    public void testCreate() throws Exception {
        User user = new User();
        user.setEmail("mail1@t.est");
        user.setPassword("123456");
        user.setRegistrationDate(new Date());
        user.addRole(roleDAO.getByName("ROLE_USER"));
        userDAO.create(user);
        assertEquals(3, userDAO.getAllUsers().size());
        assertEquals("mail1@t.est", userDAO.getByEmail("mail1@t.est").getEmail());

        userDAO.create("2mail@t.est", "123456", new Date());
        assertEquals(4, userDAO.getAllUsers().size());
        assertEquals("2mail@t.est", userDAO.getByEmail("2mail@t.est").getEmail());
    }
}
