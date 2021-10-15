package com.ruben.estudiantes.entity.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Subjects  implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_subject", nullable = false)
    private int idSubject;
    @Basic
    @Column(name = "name", nullable = false, length = 500)
    private String name;

    public int getIdSubject() {
        return idSubject;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subjects subjects = (Subjects) o;
        return idSubject == subjects.idSubject && Objects.equals(name, subjects.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSubject, name);
    }
}
