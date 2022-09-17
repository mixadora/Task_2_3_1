package MVC_Hibernate.dao;

import MVC_Hibernate.model.User;

import java.util.List;

public interface UserDAO {
    List<User> allUsers();

    void add(User user);

    void delete(int id);

    void change(User user);

    User getById(int id);

}