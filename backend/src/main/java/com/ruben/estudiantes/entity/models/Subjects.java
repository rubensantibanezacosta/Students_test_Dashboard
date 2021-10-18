package com.ruben.estudiantes.entity.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Subjects {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idsubject", nullable = false)
    private int idsubject;
    @Basic
    @Column(name = "name", nullable = false, length = 500)
    private String name;
    @OneToMany(mappedBy = "subjectsBySubjectid")
    private Collection<Califications> calificationsByIdsubject;

    public int getIdsubject() {
        return idsubject;
    }

    public void setIdsubject(int idsubject) {
        this.idsubject = idsubject;
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
        return idsubject == subjects.idsubject && Objects.equals(name, subjects.name);
    }


}
