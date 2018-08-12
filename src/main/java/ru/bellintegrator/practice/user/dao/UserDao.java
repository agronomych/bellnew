package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    /**
     * Получить всех user для списка
     */
    List<User> all() throws SQLException;

    /**
     * Получить user по id
     */
    User loadById(int id) throws SQLException ;

    /**
     * Сохранить user
     */
    void save(User user) throws SQLException ;

    /**
     * Сохранить user
     */
    void update(User user) throws SQLException ;
}
