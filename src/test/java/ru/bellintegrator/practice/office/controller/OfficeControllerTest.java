package ru.bellintegrator.practice.office.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.dao.OfficeDaoImpl;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.service.OfficeServiceImpl;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class OfficeControllerTest {



    OfficeController OCTest;
    OfficeService OSTest;
    OfficeDao OSDao;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void listOffices() {
    }

    @Test
    public void saveOffice() {
    }

    @Test
    public void updateOffice() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void getByOrgId() {
    }
}