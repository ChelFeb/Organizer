package ua.dp.skillsup.practice.organizer.dto.validator;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.dp.skillsup.practice.organizer.dto.UserInfo;

@Service
public class UserInfoValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return UserInfo.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        UserInfo userInfo = (UserInfo) obj;
        if (!userInfo.getPassword().equals(userInfo.getConfirmPassword())) {
            e.rejectValue("password", "passwordsNotMatch");
            e.rejectValue("confirmPassword", "passwordsNotMatch");
        }
    }

}




