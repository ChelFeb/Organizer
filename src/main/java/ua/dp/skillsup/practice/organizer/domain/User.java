package ua.dp.skillsup.practice.organizer.domain;

import org.hibernate.annotations.Columns;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    /**
     * E-mail as login
     * Letters, numbers, hyphens, and underscores.
     */
    @Column(nullable = false, unique = true, length = 50)
    private String email;

    /**
     * Password Letters, numbers, hyphens, and underscores, from 6 to 18 characters.
     * The password must be specified
     */
    @Column(nullable = false, length = 100)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name="userroles",
            joinColumns={@JoinColumn(name="userId", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="roleId", referencedColumnName="id")}
    )
    private List<Role> roles = new ArrayList<Role>();

    @Column(nullable = false)
    private Date registrationDate;

    public User(String email, String password, Date registrationDate) {
        this.email = email;
        this.password = password;
        if (registrationDate != null) {
            this.registrationDate = registrationDate;
        } else {
            this.registrationDate = new Date();
        }
    }

    public User(String email, String password, Date registrationDate, Role role) {
        this.email = email;
        this.password = password;
        if (registrationDate != null) {
            this.registrationDate = registrationDate;
        } else {
            this.registrationDate = new Date();
        }
        this.roles.add(role);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<Role> getRole() {
        return this.roles;
    }

    public void setRole(List<Role> role) {
        this.roles = role;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        if (!id.equals(user.id) && id != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + "\'}";
    }

}
