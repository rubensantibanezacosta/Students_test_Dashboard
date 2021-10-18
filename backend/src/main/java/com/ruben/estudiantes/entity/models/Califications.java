package com.ruben.estudiantes.entity.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(CalificationsPK.class)
public class Califications {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "subjectid", nullable = false, insertable = false, updatable = false)
    private int subjectid;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "studentdni", nullable = false, length = 15, insertable = false, updatable = false)
    private String studentdni;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "year", nullable = false, insertable = false, updatable = false)
    private int year;
    @Basic
    @Column(name = "calification", nullable = false, precision = 0)
    private double calification;
    @ManyToOne
    @JoinColumn(name = "subjectid", referencedColumnName = "idsubject", nullable = false)
    private Subjects subjectsBySubjectid;
    @ManyToOne
    @JoinColumn(name = "studentdni", referencedColumnName = "dni", nullable = false)
    private Students studentsByStudentdni;
    @ManyToOne
    @JoinColumn(name = "year", referencedColumnName = "year", nullable = false)
    private Years yearsByYear;

    public int getSubjectid() {
        return subjectid;
    }

    public void setSubjectid(int subjectid) {
        this.subjectid = subjectid;
    }

    public String getStudentdni() {
        return studentdni;
    }

    public void setStudentdni(String studentdni) {
        this.studentdni = studentdni;
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
        return subjectid == that.subjectid && year == that.year && Double.compare(that.calification, calification) == 0 && Objects.equals(studentdni, that.studentdni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectid, studentdni, year, calification);
    }

    public Subjects getSubjectsBySubjectid() {
        return subjectsBySubjectid;
    }

    public void setSubjectsBySubjectid(Subjects subjectsBySubjectid) {
        this.subjectsBySubjectid = subjectsBySubjectid;
    }

    public Students getStudentsByStudentdni() {
        return studentsByStudentdni;
    }

    public void setStudentsByStudentdni(Students studentsByStudentdni) {
        this.studentsByStudentdni = studentsByStudentdni;
    }

    public Years getYearsByYear() {
        return yearsByYear;
    }

    public void setYearsByYear(Years yearsByYear) {
        this.yearsByYear = yearsByYear;
    }
}
