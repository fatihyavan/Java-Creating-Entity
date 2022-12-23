package org.webp.ejb;

import org.webp.entity.Patient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class PatientEJB {

    @PersistenceContext
    private EntityManager entityManager;

    public Long createPatient(String name,String problem,String medicine){
        Patient patient = new Patient();
        patient.setName(name);
        patient.setProblem(problem);
        patient.setMedicine(medicine);

        entityManager.persist(patient);

        return patient.getId();
    }

    public Patient getPatientById(long id){
        Patient patient = entityManager.find(Patient.class,id);

        return patient;
    }

   public List<Patient> getAllPatients(){
        TypedQuery<Patient> query = entityManager.createQuery("select u from Patient u",Patient.class);
        return query.getResultList();
   }

   public long getNumberOfPatients(){
       TypedQuery<Patient> query = entityManager.createQuery("select count(u) from Patient u",Patient.class);
       long n = query.getSingleResult().getId();
       return n;
   }
}