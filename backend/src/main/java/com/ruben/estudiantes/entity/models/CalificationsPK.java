package com.ruben.estudiantes.entity.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CalificationsPK implements Serializable {
    @Column(name = "subjectid", nullable = false, insertable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectid;
    @Column(name = "studentdni", nullable = false, length = 15, insertable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String studentdni;
    @Column(name = "year", nullable = false, insertable = false, updatable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int year;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalificationsPK that = (CalificationsPK) o;
        return subjectid == that.subjectid && year == that.year && Objects.equals(studentdni, that.studentdni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectid, studentdni, year);
    }
}
