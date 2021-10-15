package com.ruben.estudiantes.entity.models.dao;

import com.ruben.estudiantes.entity.models.Califications;

import com.ruben.estudiantes.entity.models.CalificationsPK;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ICalificationsDao extends CrudRepository<Califications, CalificationsPK>  {
    List<Califications> findAllByDni(String dni);
}
