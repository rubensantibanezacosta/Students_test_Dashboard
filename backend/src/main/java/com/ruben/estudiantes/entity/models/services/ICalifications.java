package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Califications;



import java.util.Optional;

public interface ICalifications  {

    Optional<Califications> findByStudentDniAndSubjectIdAndYear(String studentDni, int subjectId, int year);

}
