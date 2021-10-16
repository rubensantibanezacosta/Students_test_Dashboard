package com.ruben.estudiantes.entity.models;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Students {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dni", nullable = false, length = 15)
    private String dni;
    @Basic
    @Column(name = "surname", nullable = false, length = 500)
    private String surname;
    @Basic
    @Column(name = "name", nullable = false, length = 500)
    private String name;
    @OneToMany(mappedBy = "studentsByStudentDni")
    private Collection<Califications> calificationsByDni;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
        Students students = (Students) o;
        return Objects.equals(dni, students.dni) && Objects.equals(surname, students.surname) && Objects.equals(name, students.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni, surname, name);
    }

    public Collection<Califications> getCalificationsByDni() {
        return calificationsByDni;
    }

    public void setCalificationsByDni(Collection<Califications> calificationsByDni) {
        this.calificationsByDni = calificationsByDni;
    }
}
