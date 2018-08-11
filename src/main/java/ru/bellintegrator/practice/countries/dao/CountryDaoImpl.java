package ru.bellintegrator.practice.countries.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.countries.model.Country;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @InheritDoc
 */
@Repository
public class CountryDaoImpl implements CountryDao {

    private final EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Country> all(){
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Country loadById(Integer id){
        return em.find(Country.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Country country){
        em.persist(country);
    }
}
