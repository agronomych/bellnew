package ru.bellintegrator.practice.countries.dao;

import ru.bellintegrator.practice.countries.model.Country;

import java.util.List;

/**
 * DAO для работы с Country
 */

public interface CountryDao {
    /**
     * Получить все объекты Country
     *
     * @return
     */
    List<Country> all();

    /**
     * Получить страну по коду id
     *
     * @param id
     * @return
     */
    Country loadById(Integer id);

    /**
     * Сохранить страну
     *
     * @param country
     */
    void save(Country country);
}
