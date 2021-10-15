package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Students;

import java.util.List;
import java.util.Optional;

public interface IStudents {
    public List<Students> getAll();
    public Optional<Students> getOne(String dni);
    public void add(Students student);
    public void update(Students student);
    public void delete(String dni);
}
