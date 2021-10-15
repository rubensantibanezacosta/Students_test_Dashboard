package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Subjects;

import java.util.List;
import java.util.Optional;

public interface ISubjects {
    public List<Subjects> getAll();
    public Optional<Subjects> getOne(int subject_id);
    public void add(Subjects subject);
    public void update(Subjects subject);
    public void delete(int subject_id);
}
