package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface OfficeDao {
    
    /**
     * Получить всех office для списка
     */
    List<Office> all() throws SQLException;

    /**
     * Получить office по id
     */
    Office loadById(int id) throws SQLException;

    /**
     * Сохранить office
     */
    void save(Office office) throws SQLException;

    /**
     * Сохранить office
     */
    void update(Office office) throws SQLException;

    /**
     * Получить список офисов по id организации
     */
    List<Office> loadByOrgId(int orgId) throws SQLException;
}
