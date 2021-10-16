package com.ruben.estudiantes.entity.models.dao;

import com.ruben.estudiantes.entity.models.Califications;

import com.ruben.estudiantes.entity.models.CalificationsPK;
import org.springframework.data.repository.CrudRepository;




public interface ICalificationsDao extends CrudRepository<Califications, CalificationsPK>  {

}
