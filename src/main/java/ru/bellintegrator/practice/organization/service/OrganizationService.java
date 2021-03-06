package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationView;
import ru.bellintegrator.practice.organization.view.OrganizationViewList;

import java.sql.SQLException;
import java.util.List;

public interface OrganizationService {

    List<OrganizationViewList> organizations() throws SQLException;

    void saveOrganization(OrganizationView organization) throws SQLException ;

    void updateOrganization(OrganizationView organization) throws SQLException ;

    OrganizationView loadById(int id) throws SQLException ;
}
