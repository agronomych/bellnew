package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;

public interface OrganizationService {

    List<OrganizationView> organizations();

    void saveOrganization(OrganizationView organization);

    void updateOrganization(OrganizationView organization);

    OrganizationView loadById(int id);
}
