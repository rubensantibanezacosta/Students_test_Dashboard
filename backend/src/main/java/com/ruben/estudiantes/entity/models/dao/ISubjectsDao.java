package com.ruben.estudiantes.entity.models.dao;

import com.ruben.estudiantes.entity.models.Subjects;

import org.springframework.data.repository.CrudRepository;

public interface ISubjectsDao extends CrudRepository<Subjects, Integer> {
}
