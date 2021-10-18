package com.ruben.estudiantes.entity.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(CalificationsPK.class)
public class Califications {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subjectId", nullable = false)
    private int subjectId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "studentDni", nullable = false, length = 15)
    private String studentDni;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "year", nullable = false)
    private int year;
    @Basic
    @Column(name = "calification", nullable = false, precision = 0)
    private double calification;
    @ManyToOne
    @JoinColumn(name = "subjectId", referencedColumnName = "subjectId", nullable = false)
    private Subjects subjectsBySubjectId;
    @ManyToOne
    @JoinColumn(name = "studentDni", referencedColumnName = "dni", nullable = false)
    private Students studentsByStudentDni;
    @ManyToOne
    @JoinColumn(name = "year", referencedColumnName = "year", nullable = false)
    private Years yearsByYear;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getStudentDni() {
        return studentDni;
    }

    public void setStudentDni(String studentDni) {
        this.studentDni = studentDni;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getCalification() {
        return calification;
    }

    public void setCalification(double calification) {
        this.calification = calification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Califications that = (Califications) o;
        return subjectId == that.subjectId && year == that.year && Double.compare(that.calification, calification) == 0 && Objects.equals(studentDni, that.studentDni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, studentDni, year, calification);
    }

    public Subjects getSubjectsBySubjectId() {
        return subjectsBySubjectId;
    }

    public void setSubjectsBySubjectId(Subjects subjectsBySubjectId) {
        this.subjectsBySubjectId = subjectsBySubjectId;
    }

    public Students getStudentsByStudentDni() {
        return studentsByStudentDni;
    }

    public void setStudentsByStudentDni(Students studentsByStudentDni) {
        this.studentsByStudentDni = studentsByStudentDni;
    }

    public Years getYearsByYear() {
        return yearsByYear;
    }

    public void setYearsByYear(Years yearsByYear) {
        this.yearsByYear = yearsByYear;
    }
}
