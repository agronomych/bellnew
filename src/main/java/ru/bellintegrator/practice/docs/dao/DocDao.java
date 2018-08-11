package ru.bellintegrator.practice.docs.dao;

import ru.bellintegrator.practice.docs.model.Doc;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface DocDao {
    /**
    * Получить все документы
    *
    * @return
    */
    List<Doc> all();

    /**
    * Получить документ по id
    *
    * @param id
    * @return
    */
    Doc loadById(Integer id);

    /**
    * Сохранить документ
    *
    * @param doc
    */
    void save(Doc doc);
}
