package com.ruben.estudiantes.entity.models.dao;

import com.ruben.estudiantes.entity.models.Students;

import org.springframework.data.repository.CrudRepository;

public interface IStudentsDao extends CrudRepository <Students, String>{
}
