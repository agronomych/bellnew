package ru.bellintegrator.practice.office.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;
import ru.bellintegrator.practice.office.dao.OfficeDao;
import ma.glasnost.orika.*;

import java.sql.SQLException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ru.bellintegrator.practice.office.view.OfficeViewList;

@Service
public class OfficeServiceImpl implements OfficeService{

    private final OfficeDao officeDao;

    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao){
        this.officeDao = officeDao;
    }

    @Override
    public List<OfficeViewList> offices() throws SQLException {
        List<Office> offices = officeDao.all();
        return offices.stream().map(mapOffice()).collect(Collectors.toList());
    }

    @Override
    public void saveOffice(OfficeView officeView) throws SQLException {
        officeDao.save(viewToOffice(officeView));
    }

    @Override
    public void updateOffice(OfficeView officeView) throws SQLException {
        officeDao.update(viewToOffice(officeView));
    }

    @Override
    public OfficeView loadById(int id) throws SQLException {
        return officeToView(officeDao.loadById(id));
    }

    private Function<Office,OfficeViewList> mapOffice(){
        return o -> {
            return officeToViewList(o);
        };
    }

    @Override
    public List<OfficeViewList> loadByOrgId(int orgId) throws SQLException {
        return officeDao.loadByOrgId(orgId).stream().map(this::officeToViewList).collect(Collectors.toList());
    }

    private Office viewToOffice(OfficeView view){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OfficeView.class,Office.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(view,Office.class);
    }

    private OfficeView officeToView(Office office){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OfficeView.class,Office.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(office,OfficeView.class);
    }

    private OfficeViewList officeToViewList(Office office){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OfficeViewList.class,Office.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(office,OfficeViewList.class);
    }
}
