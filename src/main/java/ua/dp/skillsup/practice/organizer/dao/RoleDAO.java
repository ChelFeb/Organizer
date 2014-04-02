package ua.dp.skillsup.practice.organizer.dao;

import ua.dp.skillsup.practice.organizer.domain.*;

public interface RoleDAO {

    /**
     * Get Role by id
     *
     * @param id identifier
     */
    Role getById(Integer id);

    /**
     * Get Role by name
     *
     * @param name identifier
     */
    Role getByName(String name);
}
