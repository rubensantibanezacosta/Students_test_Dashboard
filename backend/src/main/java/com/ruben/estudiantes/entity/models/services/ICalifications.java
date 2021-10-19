package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Califications;


import java.util.List;
import java.util.Optional;

public interface ICalifications  {

    Optional<Califications> findByStudentDniAndSubjectIdAAndYears(String studentDni, int subjectId, int year);
    List<Califications> findAllByStudentDniAndYears(String studentDni, int year);

    void deleteCalification(String studentDni, int subjectId, int year);

    void add(Califications calification);

}
