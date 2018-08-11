package ru.bellintegrator.practice.office.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;

@Repository
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
    @Transactional
    public List<Office> all(){
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
    public Office loadById(int id){
        return em.find(Office.class, id);
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void save(Office office){
        em.persist(office);
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void update(Office office){

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<Office> cUpdate = builder.createCriteriaUpdate(Office.class);
        Root offices = cUpdate.from(Office.class);
        System.out.println("============  " + office.getId() + "  +++++++++++");
        System.out.println("============  " + office.getPhone() + "  +++++++++++");
        System.out.println("============  " + office.getAddress() + "  +++++++++++");
        System.out.println("============  " + office.getName() + "  +++++++++++");
        System.out.println("============  " + office.getOrgId() + "  +++++++++++");
        System.out.println("============  " + office.getActive() + "  +++++++++++");
        cUpdate.where(builder.equal(offices.get("name"),office.getName()));
        cUpdate.set("isactive", office.getActive());
        cUpdate.set("phone", office.getPhone());
        cUpdate.set("address", office.getAddress());
        cUpdate.set("name", office.getName());
        cUpdate.set("orgid", office.getOrgId());
        //cUpdate.set("id", office.getId());
        Query query = em.createQuery(cUpdate);
        query.executeUpdate();
    }

}