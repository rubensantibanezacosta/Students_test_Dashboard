package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Califications;


import java.util.List;
import java.util.Optional;

public interface ICalifications  {

    Optional<Califications> findByStudentDniAndSubjectIdAAndYear(String studentDni, int subjectId, int year);
    List<Califications> findAllByStudentDniAndYear(String studentDni, int year);

    void deleteCalification(String studentDni, int subjectId, int year);

    void add(Califications calification);

}
