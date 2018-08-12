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
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

@Repository
@Transactional
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
    public List<Organization> all() throws SQLException {
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
    public Organization loadById(int id) throws SQLException {
        return em.find(Organization.class, id);
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void save(Organization organization) throws SQLException {
        em.persist(organization);
    }


    /**
     * {@InheritDoc}
     */
    @Override
    public void update(Organization organization) throws SQLException {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<Organization> cUpdate = builder.createCriteriaUpdate(Organization.class);
        Root organizations = cUpdate.from(Organization.class);
        cUpdate.where(builder.equal(organizations.get("id"),organization.getId()));
        if (organization.getIsactive()!=null) cUpdate.set("isactive",organization.getIsactive());
        if (organization.getPhone()!=null) cUpdate.set("phone",organization.getPhone());
        if (organization.getAddress()!=null) cUpdate.set("address",organization.getAddress());
        if (organization.getName()!=null) cUpdate.set("name",organization.getName());
        if (organization.getFullname()!=null) cUpdate.set("fullname",organization.getFullname());
        if (organization.getInn()!=null) cUpdate.set("inn",organization.getInn());
        if (organization.getKpp()!=null) cUpdate.set("kpp",organization.getKpp());

        Query query = em.createQuery(cUpdate);
        query.executeUpdate();
    }
}
