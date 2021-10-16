package com.ruben.estudiantes.entity.models;

import javax.persistence.*;

@Entity
public class Years {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "year", nullable = false)
    private int year;
    @OneToMany(mappedBy = "yearsByYear")
   

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

/* 
    private Collection<Califications> calificationsByYear;

    public Collection<Califications> getCalificationsByYear() {
        return calificationsByYear;
    }

    public void setCalificationsByYear(Collection<Califications> calificationsByYear) {
        this.calificationsByYear = calificationsByYear;
    } */
}
