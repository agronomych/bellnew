package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.office.view.OfficeViewList;

import java.sql.SQLException;
import java.util.List;

public interface OfficeService {
    List<OfficeViewList> offices() throws SQLException;

    void saveOffice(OfficeView office) throws SQLException ;

    void updateOffice(OfficeView office) throws SQLException ;

    OfficeView loadById(int id) throws SQLException ;

    List<OfficeViewList> loadByOrgId(int orgId) throws SQLException;
}
