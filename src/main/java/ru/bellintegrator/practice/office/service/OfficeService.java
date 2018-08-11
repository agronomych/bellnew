package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;

public interface OfficeService {
    List<OfficeView> offices();

    void saveOffice(OfficeView office);

    void updateOffice(OfficeView office);

    OfficeView loadById(int id);
}