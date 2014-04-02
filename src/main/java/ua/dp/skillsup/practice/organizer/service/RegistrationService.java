package ua.dp.skillsup.practice.organizer.service;

import ua.dp.skillsup.practice.organizer.dto.UserInfo;
import ua.dp.skillsup.practice.organizer.exception.registration.RegistrationException;

public interface RegistrationService {

    void registerUser(UserInfo user) throws RegistrationException;

}
