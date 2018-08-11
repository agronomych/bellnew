package ru.bellintegrator.practice.office.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Application;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ru.bellintegrator.practice.office.model.Office;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeControllerTest {

    @Autowired
    OfficeDao dao;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void listOffices() {
        System.out.println("______________________________");
        System.out.println(dao.all().size());
        System.out.println("______________________________");
    }

    @Test
    public void saveOffice() {
        Office office = new Office();
        office.setAddress("rrr");
        office.setActive(true);
        office.setName("aaa");
        office.setOrgId(1);
        office.setPhone("121");
        dao.save(office);
        System.out.println("______________________________");
        System.out.println("Saved!");
        System.out.println("______________________________");
    }

    @Test
    public void updateOffice() {
        System.out.println("__________________________________");
        System.out.println("Previous");
        System.out.println(dao.loadById(1).getId() + ". " + dao.loadById(1).getName());
        System.out.println(dao.loadById(2).getId() + ". " + dao.loadById(2).getName());
        System.out.println(dao.loadById(3).getId() + ". " + dao.loadById(3).getName());
        System.out.println(dao.loadById(4).getId() + ". " + dao.loadById(4).getName());
        System.out.println(dao.loadById(5).getId() + ". " + dao.loadById(5).getName());
        System.out.println(dao.all().size());
        Office office = new Office();
        office.setAddress("rrr");
        office.setActive(true);
        office.setName("bbb");
        office.setOrgId(1);
        office.setPhone("121");
        office.setId(1);
        dao.update(office);
        System.out.println("__________________________________");
        System.out.println("Changed");
        System.out.println(dao.loadById(1).getId() + ". " + dao.loadById(1).getName());
        System.out.println(dao.loadById(2).getId() + ". " + dao.loadById(2).getName());
        System.out.println(dao.loadById(3).getId() + ". " + dao.loadById(3).getName());
        System.out.println(dao.loadById(4).getId() + ". " + dao.loadById(4).getName());
        System.out.println(dao.loadById(5).getId() + ". " + dao.loadById(5).getName());
        System.out.println(dao.all().size());
    }
}