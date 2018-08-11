package ru.bellintegrator.practice.organization.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao{

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em){
        this.em = em;
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public List<Organization> all(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery(Organization.class);
        cQuery.from(Organization.class);
        Query query = em.createQuery(cQuery);
        return query.getResultList();
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public Organization loadById(int id){
        return em.find(Organization.class, id);
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void save(Organization organization){
        em.persist(organization);
    }


    /**
     * {@InheritDoc}
     */
    @Override
    public void update(Organization organization){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<Organization> cUpdate = builder.createCriteriaUpdate(Organization.class);
        Root organizations = cUpdate.from(Organization.class);
        cUpdate.where(builder.equal(organizations.get("id"),organization.getId()));
        if (organization.getActive()!=null) cUpdate.set("isActive",organization.getActive());
        if (organization.getPhone()!=null) cUpdate.set("phone",organization.getPhone());
        if (organization.getAddress()!=null) cUpdate.set("address",organization.getAddress());
        if (organization.getName()!=null) cUpdate.set("name",organization.getName());
        if (organization.getFullName()!=null) cUpdate.set("fullName",organization.getFullName());
        if (organization.getInn()!=null) cUpdate.set("inn",organization.getInn());
        if (organization.getKpp()!=null) cUpdate.set("kpp",organization.getKpp());

        Query query = em.createQuery(cUpdate);
        query.executeUpdate();
    }
}
