package ru.bellintegrator.practice.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private final EntityManager em;

    @Autowired
    public UserDaoImpl(EntityManager em){
        this.em = em;
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public List<User> all(){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery cQuery = builder.createQuery(User.class);
        cQuery.from(User.class);
        Query query = em.createQuery(cQuery);
        return query.getResultList();
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public User loadById(int id){
        return em.find(User.class, id);
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void save(User user){
        em.persist(user);
    }

    /**
     * {@InheritDoc}
     */
    @Override
    public void update(User user){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<User> cUpdate = builder.createCriteriaUpdate(User.class);
        Root users = cUpdate.from(User.class);
        cUpdate.where(builder.equal(users.get("id"),user.getId()));
        /*if (user.getPhone()!=null) cUpdate.set("phone",user.getPhone());
        if (user.getFirstName()!=null) cUpdate.set("firstName",user.getFirstName());
        if (user.getLastName()!=null) cUpdate.set("lastName",user.getLastName());
        if (user.getMiddleName()!=null) cUpdate.set("middleName",user.getMiddleName());
        if (user.getPosition()!=null) cUpdate.set("position",user.getPosition());
        if (user.getOfficeId()!=null) cUpdate.set("officeId",user.getOfficeId());
        if (user.getPhone()!=null) cUpdate.set("phone",user.getPhone());
        if (user.getCitizenshipId()!=null) cUpdate.set("citizenshipId",user.getCitizenshipId());
        if (user.getDocId()!=null) cUpdate.set("docId",user.getDocId());
        if (user.getDocNumber()!=null) cUpdate.set("docNumber",user.getDocNumber());
        if (user.getDocDate()!=null) cUpdate.set("docDate",user.getDocDate());*/
        Query query = em.createQuery(cUpdate);
        query.executeUpdate();
    }
}
