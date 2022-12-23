package org.webp.ejb;

import org.webp.entity.Polyclinic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.*;

@Stateless
public class PolyclinicEJB{

    @PersistenceContext
    private EntityManager entityManager;

    public PolyclinicEJB(){}

    public void createPolyclinic(String name,Long numberOfPation){

        Polyclinic polyclinic = new Polyclinic();

        polyclinic.setName(name);
        polyclinic.setNumberOfPation(numberOfPation);

        entityManager.persist(polyclinic);



    }

    public List<Polyclinic> getPolyclinic(){
        TypedQuery<Polyclinic> query = entityManager.createQuery("select p from Post p", Polyclinic.class);
        return query.getResultList();
    }

}