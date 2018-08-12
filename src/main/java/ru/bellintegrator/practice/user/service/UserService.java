package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.view.UserView;

import java.sql.SQLException;
import java.util.List;

public interface UserService{

    List<UserView> users() throws SQLException;

    void saveUser(UserView user) throws SQLException ;

    void updateUser(UserView user) throws SQLException ;

    UserView loadById(int id) throws Exception;
}
