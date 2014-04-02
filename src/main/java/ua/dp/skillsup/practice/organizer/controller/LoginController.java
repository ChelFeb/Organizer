package ua.dp.skillsup.practice.organizer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static ua.dp.skillsup.practice.organizer.util.Constants.*;


/**
 * Controller which get login page
 *
 * @author Shaman
 */
@Controller
public class LoginController {

    /**
     * Getting login page
     *
     * @return login view
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return LOGIN_VIEW;
    }

    /**
     * Getting loginfailed message
     *
     * @param model loginfailed model
     * @return login view
     */
    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String fail(Model model) {
        model.addAttribute("fail", "Incorrect email and/or password");
        return LOGIN_VIEW;
    }
}

