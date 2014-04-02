package ua.dp.skillsup.practice.organizer.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull(message = "The role name  must be specified")
    @Column(unique = true, length = 25)
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
