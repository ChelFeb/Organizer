package ua.dp.skillsup.practice.organizer.service.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import ua.dp.skillsup.practice.IntegrationTest;
import ua.dp.skillsup.practice.organizer.dao.UserDAO;
import ua.dp.skillsup.practice.organizer.domain.User;
import ua.dp.skillsup.practice.organizer.dto.UserInfo;
import ua.dp.skillsup.practice.organizer.exception.registration.CreateNewUserException;
import ua.dp.skillsup.practice.organizer.exception.registration.RegistrationException;
import ua.dp.skillsup.practice.organizer.service.RegistrationService;

public class RegisterServiceImplTest extends IntegrationTest {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    UserDAO userDAO;

    @Before
    public void init() {
        initializeData();
    }

    @Test(expected = CreateNewUserException.class)
    public void testCreateNewUserException() throws RegistrationException {
        UserInfo info = new UserInfo();
        info.setEmail("test1@test.com");
        registrationService.registerUser(info);
    }

    @Test
    public void testUserRegistration() {
        UserInfo info = new UserInfo();
        info.setEmail("TestEmail@mail.ml");
        info.setPassword("123456");
        info.setConfirmPassword("123456");

        try {
            registrationService.registerUser(info);
            User userFromDB = userDAO.getByEmail("TestEmail@mail.ml");
            Assert.assertEquals(new Md5PasswordEncoder().encodePassword(info.getPassword(), null), userFromDB.getPassword());
            Assert.assertEquals(info.getEmail(), userFromDB.getEmail());
        } catch (RegistrationException e) {
            Assert.fail("Unexpected exception thrown during valid user creation");
        }

    }
}
