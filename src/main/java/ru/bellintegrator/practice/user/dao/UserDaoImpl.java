package ru.bellintegrator.practice.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
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
        if (user.getPhone()!=null) cUpdate.set("phone",user.getPhone());
        if (user.getFirstname()!=null) cUpdate.set("firstname",user.getFirstname());
        if (user.getLastname()!=null) cUpdate.set("lastname",user.getLastname());
        if (user.getMiddlename()!=null) cUpdate.set("middlename",user.getMiddlename());
        if (user.getPosition()!=null) cUpdate.set("position",user.getPosition());
        if (user.getOfficeid()!=null) cUpdate.set("officeid",user.getOfficeid());
        if (user.getCitizenshipid()!=null) cUpdate.set("citizenshipid",user.getCitizenshipid());
        if (user.getDocid()!=null) cUpdate.set("docid",user.getDocid());
        if (user.getDocnumber()!=null) cUpdate.set("docnumber",user.getDocnumber());
        if (user.getDocdate()!=null) cUpdate.set("docdate",user.getDocdate());
        Query query = em.createQuery(cUpdate);
        query.executeUpdate();
    }
}
