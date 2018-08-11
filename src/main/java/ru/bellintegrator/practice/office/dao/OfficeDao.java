package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;

import java.util.List;

public interface OfficeDao {
    
    /**
     * Получить всех office для списка
     */
    List<Office> all();

    /**
     * Получить office по id
     */
    Office loadById(int id);

    /**
     * Сохранить office
     */
    void save(Office office);

    /**
     * Сохранить office
     */
    void update(Office office);
}
