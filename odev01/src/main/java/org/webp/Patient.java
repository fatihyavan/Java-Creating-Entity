package org.webp;

import javax.persistence.*;

@Table(name = "Patient")
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Problem")
    private String problem;

    @Column(name = "Medicine")
    private String medicine;

    public Patient(){
    }

    public Patient(Long id, String name, String problem, String medicine) {
        this.id = id;
        this.name = name;
        this.problem = problem;
        this.medicine = medicine;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }
}