package com.ruben.estudiantes.entity.models.services;


import com.ruben.estudiantes.entity.models.Califications;
import com.ruben.estudiantes.entity.models.dao.ICalificationsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CalificationsImpl implements  ICalifications{
   @Autowired
   ICalificationsDao iCalificationsDao;



    @Override
    public Optional<Califications> findByStudentDniAndSubjectIdAAndYear(String studentDni, int subjectId, int year) {
        return iCalificationsDao.findByStudentdniAndSubjectidAndYear(studentDni,subjectId,year);
    }
}
