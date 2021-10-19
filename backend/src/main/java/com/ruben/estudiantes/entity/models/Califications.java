package com.ruben.estudiantes.entity.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@IdClass(CalificationsPK.class)
public class Califications {

    @Id
    @Column(name = "subjectid", nullable = false)
    private int subjectid;

    @Id
    @Column(name = "studentdni", nullable = false, length = 15)
    private String studentdni;

    @Id
    @Column(name = "years", nullable = false)
    private int years;
    @Basic
    @Column(name = "calification", nullable = false, precision = 0)
    private double calification;
    @ManyToOne
    @JoinColumn(name = "subjectid", referencedColumnName = "idsubject", nullable = false, updatable = false, insertable = false)
    private Subjects subjectsBySubjectid;

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

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
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
        return subjectid == that.subjectid && years == that.years && Double.compare(that.calification, calification) == 0 && Objects.equals(studentdni, that.studentdni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectid, studentdni, years, calification);
    }

    public Subjects getSubjectsBySubjectid() {
        return subjectsBySubjectid;
    }

    public void setSubjectsBySubjectid(Subjects subjectsBySubjectid) {
        this.subjectsBySubjectid = subjectsBySubjectid;
    }



}
