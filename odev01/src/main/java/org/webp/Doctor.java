package org.webp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "Doctor")
@Entity
public class Doctor {

    @Column(name = "Name",length = 20)
    private String name;

    @Column(name = "Salary")
    private Integer salary;

    public Doctor(){
    }

    public Doctor(String name, Integer salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}