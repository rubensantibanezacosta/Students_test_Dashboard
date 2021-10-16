package com.ruben.estudiantes.entity.models.dao;

import com.ruben.estudiantes.entity.models.Califications;
import com.ruben.estudiantes.entity.models.CalificationsPK;
import com.ruben.estudiantes.entity.models.Students;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ICalificationsDao extends CrudRepository <Califications, CalificationsPK> {
    Optional<Califications> findByStudentDniAndSubjectIdAAndYear(String studentDni, int subjectId, int year);
}
