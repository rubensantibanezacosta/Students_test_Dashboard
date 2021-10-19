package com.ruben.estudiantes.entity.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Years {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "year", nullable = false)
    public int year;
    @JsonIgnore
    @OneToMany(mappedBy = "yearsByYears")
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

    @Override
    public int hashCode() {
        return Objects.hash(year);
    }

}
