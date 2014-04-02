package ua.dp.skillsup.practice.organizer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dp.skillsup.practice.organizer.dao.RoleDAO;
import ua.dp.skillsup.practice.organizer.dao.UserDAO;
import ua.dp.skillsup.practice.organizer.dao.impl.RoleDAOimpl;
import ua.dp.skillsup.practice.organizer.domain.User;
import ua.dp.skillsup.practice.organizer.domain.Role;
import ua.dp.skillsup.practice.organizer.dto.UserInfo;
import ua.dp.skillsup.practice.organizer.exception.registration.CreateNewUserException;
import ua.dp.skillsup.practice.organizer.exception.registration.RegistrationException;
import ua.dp.skillsup.practice.organizer.service.RegistrationService;

import java.util.Date;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    UserDAO userDAO;
    @Autowired
    RoleDAO roleDAO;

    @Transactional
    public void registerUser(UserInfo userInfo) throws RegistrationException {
        if (userDAO.getByEmail(userInfo.getEmail()) != null) {
            throw new CreateNewUserException("Email already occupied");
        }
            User user = new User(userInfo.getEmail(),
                        new Md5PasswordEncoder().encodePassword(userInfo.getPassword(), null),
                        new Date(),
                        roleDAO.getByName("ROLE_USER")
            );
            userDAO.create(user);
    }
}
