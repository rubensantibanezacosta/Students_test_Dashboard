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


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


}
