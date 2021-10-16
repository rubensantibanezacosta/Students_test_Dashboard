package com.ruben.estudiantes.entity.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CalificationsPK implements Serializable {
    @Column(name = "subject_id", nullable = false , insertable=false, updatable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;
    @Column(name = "student_dni", nullable = false, length = 15, insertable=false, updatable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private String studentDni;
    @Column(name = "year", nullable = false , insertable=false, updatable=false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int year;



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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalificationsPK that = (CalificationsPK) o;
        return subjectId == that.subjectId && year == that.year && Objects.equals(studentDni, that.studentDni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectId, studentDni, year);
    }
}
