package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.model.User;

import java.util.List;

public interface UserDao {

    /**
     * Получить всех user для списка
     */
    List<User> all();

    /**
     * Получить user по id
     */
    User loadById(int id);

    /**
     * Сохранить user
     */
    void save(User user);

    /**
     * Сохранить user
     */
    void update(User user);
}
