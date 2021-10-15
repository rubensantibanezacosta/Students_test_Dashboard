package com.ruben.estudiantes.entity.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@IdClass(CalificationsPK.class)
public class Califications implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subject_id", nullable = false)
    private int subjectId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_dni", nullable = false, length = 15)
    private String studentDni;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "year", nullable = false)
    private int year;
    @Basic
    @Column(name = "calification", nullable = false, precision = 0)
    private double calification;
    @ManyToOne
    @JoinColumn(name = "student_dni", referencedColumnName = "dni", nullable = false, insertable = false, updatable = false)
    private Students studentsByStudentDni;
    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id_subject", nullable = false,  insertable = false, updatable = false)
    private Subjects subjectsBySubjectId;
    @ManyToOne
    @JoinColumn(name = "year", referencedColumnName = "year", nullable = false, insertable = false, updatable = false)
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

    public Students getStudentsByStudentDni() {
        return studentsByStudentDni;
    }

    public void setStudentsByStudentDni(Students studentsByStudentDni) {
        this.studentsByStudentDni = studentsByStudentDni;
    }

    public Subjects getSubjectsBySubjectId() {
        return subjectsBySubjectId;
    }

    public void setSubjectsBySubjectId(Subjects subjectsBySubjectId) {
        this.subjectsBySubjectId = subjectsBySubjectId;
    }

    public Years getYearsByYear() {
        return yearsByYear;
    }

    public void setYearsByYear(Years yearsByYear) {
        this.yearsByYear = yearsByYear;
    }
}
