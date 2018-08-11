package ru.bellintegrator.practice.organization.service;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.organization.dao.OrganizationDao;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.view.OrganizationView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements OrganizationService{

    private final OrganizationDao organizationDao;

    @Autowired
    public OrganizationServiceImpl(OrganizationDao organizationDao){
        this.organizationDao = organizationDao;
    }

    @Override
    public List<OrganizationView> organizations(){
        List<Organization> offices = organizationDao.all();
        return offices.stream()
                .map(mapOrganization())
                .collect(Collectors.toList());
    }

    @Override
    public void saveOrganization(OrganizationView view){
        organizationDao.save(viewToOrganization(view));
    }

    @Override
    public void updateOrganization(OrganizationView view){
        organizationDao.update(viewToOrganization(view));
    }

    @Override
    public OrganizationView loadById(int id){
        return organizationToView(organizationDao.loadById(id));
    }

    private Function<Organization,OrganizationView> mapOrganization(){
        return o -> {
            return organizationToView(o);
        };
    }

    private Organization viewToOrganization(OrganizationView view){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OrganizationView.class,Organization.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(view,Organization.class);
    }

    private OrganizationView organizationToView(Organization office){
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(OrganizationView.class,Organization.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(office,OrganizationView.class);
    }
}
