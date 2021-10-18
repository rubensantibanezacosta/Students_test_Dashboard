package com.ruben.estudiantes.entity.models.services;

import java.util.List;
import java.util.Optional;

import com.ruben.estudiantes.entity.models.Subjects;

public interface ISubjects {
    public List<Subjects> getAll();
    public Optional<Subjects> getOne(int subjectId);
    public void add(Subjects subject);
    public void update(Subjects subject);
    public void delete(int subjectId);
}
