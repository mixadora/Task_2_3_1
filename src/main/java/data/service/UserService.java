package data.service;

import data.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    void add(User user);

    void delete(int id);

    void change(User user);

}
