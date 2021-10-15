package com.ruben.estudiantes.entity.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Years  implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "year", nullable = false)
    private int year;


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
