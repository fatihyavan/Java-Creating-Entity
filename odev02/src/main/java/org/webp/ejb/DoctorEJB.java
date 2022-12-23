package org.webp.ejb;

import org.webp.entity.Doctor;
import org.webp.entity.Patient;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class DoctorEJB {

    @PersistenceContext
    private EntityManager entityManager;

    public DoctorEJB(){}

    public void hireADoctor(long id,String name,Integer salary){
        if(isEmployee(name)){
            return;
        }

        PatientEJB patientejb = new PatientEJB();
        Patient patient = patientejb.getPatientById(id);

        Doctor doctor = new Doctor();
        doctor.setName(name);
        doctor.setSalary(salary);
        doctor.setPatient(patient);

        entityManager.persist(doctor);
    }

    public boolean isEmployee(String name){
        Doctor doctor = entityManager.find(Doctor.class,name);
        return doctor != null;
    }

    public long getNumberOfDoctors(){
        TypedQuery<Long> query = entityManager.createQuery("select count(u) from Doctor u",Long.class);
        long n = query.getSingleResult();
        return n;
    }

}
