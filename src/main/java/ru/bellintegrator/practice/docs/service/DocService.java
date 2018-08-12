package ru.bellintegrator.practice.docs.service;

import ru.bellintegrator.practice.docs.model.Doc;
import ru.bellintegrator.practice.docs.view.DocView;

import java.util.List;

/**
 * Сервис
 */
public interface DocService {

    /**
     * Добавить нового документа в БД
     *
     * @param doc
     */
    void add(DocView doc);

    /**
     * Получить список документов
     *
     * @return {@Doc}
     */
    List<DocView> docs();

    /**
     * Получить документ по id
     *
     * @return {@Person}
     */
    DocView loadById(int id);

}