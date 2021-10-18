package com.ruben.estudiantes.entity.models.dao;

import com.ruben.estudiantes.entity.models.Califications;
import com.ruben.estudiantes.entity.models.CalificationsPK;
import com.ruben.estudiantes.entity.models.Students;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICalificationsDao extends CrudRepository <Califications, CalificationsPK> {
   // @Query("SELECT c  FROM Califications c  WHERE c.studentDni = :dni AND c.subjectId = :subjectId AND c.year = :year")
    Optional<Califications> findByStudentDniAndSubjectIdAndYear(@Param("dni") String studentDni, @Param("subjectId") int subjectId, @Param("year") int  year);

}