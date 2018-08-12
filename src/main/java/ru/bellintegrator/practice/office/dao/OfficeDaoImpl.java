package ru.bellintegrator.practice.office.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public class OfficeDaoImpl implements OfficeDao {

    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em){
        this.em = em;
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public List<Office> all() throws SQLException {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery(Office.class);
        cQuery.from(Office.class);
        Query query = em.createQuery(cQuery);
        return query.getResultList();
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public Office loadById(int id) throws SQLException {
        return em.find(Office.class, id);
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void save(Office office) throws SQLException{
        em.persist(office);
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void update(Office office) throws SQLException {

        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaUpdate<Office> cUpdate = builder.createCriteriaUpdate(Office.class);
        Root offices = cUpdate.from(Office.class);
        cUpdate.where(builder.equal(offices.get("id"),office.getId()));
        System.out.println("Address in DAO - "+office.getAddress());
        if (office.getIsactive()!=null) cUpdate.set("isactive",office.getIsactive());
        if (office.getPhone()!=null) cUpdate.set("phone",office.getPhone());
        if (office.getAddress()!=null) cUpdate.set("address",office.getAddress());
        if (office.getName()!=null) cUpdate.set("name",office.getName());
        if (office.getOrgid()==null) cUpdate.set("orgid",office.getOrgid());
        Query query = em.createQuery(cUpdate);
        query.executeUpdate();
    }

    @Override
    public List<Office> loadByOrgId(int orgId)throws SQLException{
        Set<Office> result;
        CriteriaBuilder builder = this.em.getCriteriaBuilder();
        CriteriaQuery<Office> cQuery = builder.createQuery(Office.class);
        Root root = cQuery.from(Office.class);
        cQuery.select(root);
        cQuery.where(builder.equal(root.get("orgid"),orgId));
        Query query = em.createQuery(cQuery);
        return query.getResultList();
    }
}