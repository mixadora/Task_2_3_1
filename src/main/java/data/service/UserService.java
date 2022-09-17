package MVC_Hibernate.service;

import MVC_Hibernate.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    void add(User user);

    void delete(int id);

    void change(User user);

}
