package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.organization.model.Organization;

import java.sql.SQLException;
import java.util.List;

public interface OrganizationDao {


    /**
     * Получить всех organization для списка
     */
    List<Organization> all() throws SQLException;

    /**
     * Получить organization по id
     */
    Organization loadById(int id) throws SQLException ;

    /**
     * Сохранить organization
     */
    void save(Organization organization) throws SQLException ;

    /**
     * Сохранить organization
     */
    void update(Organization organization) throws SQLException ;
}
