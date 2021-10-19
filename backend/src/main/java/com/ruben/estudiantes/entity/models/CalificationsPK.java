package com.ruben.estudiantes.entity.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CalificationsPK implements Serializable {



    private int subjectid;


    private String studentdni;

    private int years;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CalificationsPK that = (CalificationsPK) o;
        return subjectid == that.subjectid && years == that.years && Objects.equals(studentdni, that.studentdni);
    }

    public CalificationsPK() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectid, studentdni, years);
    }
}
