package ua.dp.skillsup.practice.organizer.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import ua.dp.skillsup.practice.organizer.dto.UserInfo;
import ua.dp.skillsup.practice.organizer.dto.validator.UserInfoValidator;
import ua.dp.skillsup.practice.organizer.exception.registration.RegistrationException;
import ua.dp.skillsup.practice.organizer.service.RegistrationService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationControllerTest {

    @InjectMocks
    private RegistrationController registrationController;

    @Mock
    private RegistrationService registrationService;

    @Mock
    private UserInfoValidator userInfoValidator;

    @Mock
    private ModelMap modelMap;

    @Mock
    private Model model;

    @Mock
    private UserInfo userInfo;

    @Mock
    BindingResult validationResult;

    @Test
    public void testGetRegistrationPage() {
        assertEquals("registration", registrationController.open(modelMap));
    }

    @Test
    public void testAddNewUser() throws RegistrationException {
        registrationController.addNewUser(userInfo, validationResult, model);
        verify(registrationService).registerUser(Matchers.<UserInfo>anyObject());
        assertEquals("redirect:/", registrationController.addNewUser(userInfo, validationResult, model));

    }

}
