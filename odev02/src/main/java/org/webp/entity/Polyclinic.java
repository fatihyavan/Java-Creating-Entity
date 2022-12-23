package org.webp.entity;

import javax.persistence.*;

@Table(name = "Polyclinic")
@Entity
public class Polyclinic {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name = "POLYCLINIC_NAME",length = 20,nullable = false)
    private String name;

    @Column(name = "Number of pation",length = 5)
    private Long numberOfPation;

     @OneToOne
     private Doctor doctor;

    public Polyclinic(){
    }

    public Polyclinic(Long id, String name, Long numberOfPation) {
        this.id = id;
        this.name = name;
        this.numberOfPation = numberOfPation;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNumberOfPation() {
        return numberOfPation;
    }

    public void setNumberOfPation(Long numberOfPation) {
        this.numberOfPation = numberOfPation;
    }
}