package ru.bellintegrator.practice.docs.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.bellintegrator.practice.docs.model.Doc;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @InheritDoc
 */
@Repository
public class DocDaoImpl implements DocDao {

    @Autowired
    private final EntityManager em;

    public DocDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<Doc> all(){
        TypedQuery query = em.createQuery("SELECT h FROM Doc h", Doc.class);
        List<Doc> result = query.getResultList();
        return query.getResultList();
        //return new LinkedList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Doc loadById(Integer id){
        return em.find(Doc.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Doc doc){
        em.persist(doc);

    }
}
