package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.view.UserView;

import java.util.List;

public interface UserService {

    List<UserView> users();

    void saveUser(UserView user);

    void updateUser(UserView user);

    UserView loadById(int id);
}
