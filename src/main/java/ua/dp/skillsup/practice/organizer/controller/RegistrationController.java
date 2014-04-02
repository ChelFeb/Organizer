package ua.dp.skillsup.practice.organizer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.dp.skillsup.practice.organizer.dto.UserInfo;
import ua.dp.skillsup.practice.organizer.dto.validator.UserInfoValidator;
import ua.dp.skillsup.practice.organizer.exception.registration.RegistrationException;
import ua.dp.skillsup.practice.organizer.service.RegistrationService;
import static ua.dp.skillsup.practice.organizer.util.Constants.*;

import javax.validation.Valid;

/**
 * Controller which get login page
 *
 * @author Shaman
 */
@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

    @Autowired
    UserInfoValidator userInfoValidator;

    @Autowired
    RegistrationService registrationService;

    private static final Logger LOG = LoggerFactory.getLogger(RegistrationController.class);

    /**
     * AShowing registration page
     *
     * @param model blank userInfo model
     * @return login view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String open(ModelMap model) {
        UserInfo userInfo = new UserInfo();
        model.put("userInfo", userInfo);
        return REGISTRATION_VIEW;
    }

    /**
     * Adding new user to database
     *
     * @param userInfo user info DTO object
     * @param validationResult spring validation bindingResult object
     * @param model errorMessageModel model
     * @return login view
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addNewUser(@ModelAttribute("userInfo") @Valid UserInfo userInfo, BindingResult validationResult, Model model) {

        userInfoValidator.validate(userInfo, validationResult);

        if(validationResult.hasErrors()) {
            return REGISTRATION_VIEW;
        }

        try {
            registrationService.registerUser(userInfo);
        } catch (RegistrationException e) {
            model.addAttribute("errorMessage", e.getMessage());
            LOG.info("context", e.getMessage());
            return REGISTRATION_VIEW;
        }

        return REDIRECT;
    }
}
