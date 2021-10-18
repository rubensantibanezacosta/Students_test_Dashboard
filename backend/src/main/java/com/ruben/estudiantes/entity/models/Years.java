package com.ruben.estudiantes.entity.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Years {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "year", nullable = false)
    private int year;
    @OneToMany(mappedBy = "yearsByYear")
    private Collection<Califications> calificationsByYear;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Years years = (Years) o;
        return year == years.year;
    }


}
