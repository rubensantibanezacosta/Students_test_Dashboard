package com.ruben.estudiantes.entity.models.dao;

import com.ruben.estudiantes.entity.models.Califications;
import com.ruben.estudiantes.entity.models.CalificationsPK;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

public interface ICalificationsDao extends CrudRepository <Califications, CalificationsPK> {

   Optional<Califications> findByStudentdniAndSubjectidAndYears(String studentDni, int subjectId, int  year);
   List<Califications> findAllByStudentdniAndYears(String studentDni, int year);
   @Transactional
   void deleteCalificationsByStudentdniAndSubjectidAndYears(String studentDni, int subjectId, int  year);


}
