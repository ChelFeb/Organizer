package ua.dp.skillsup.practice.organizer.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class UserInfo {

    @NotEmpty (message = "You have to specify email")
    @Email (message = "Incorrect email")
    private String email;

    @Size(min=6, max=18, message = "Password should contain from 6 to 18 characters")
    private String password;

    @Size(min=6, max=18, message = "Password should contain from 6 to 18 characters")
    private String confirmPassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
