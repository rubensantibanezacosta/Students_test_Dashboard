package com.ruben.estudiantes.entity.models.services;


import com.ruben.estudiantes.entity.models.Califications;
import com.ruben.estudiantes.entity.models.dao.ICalificationsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificationsImpl implements  ICalifications {
    @Autowired
    ICalificationsDao iCalificationsDao;


    @Override
    public Optional<Califications> findByStudentDniAndSubjectIdAAndYear(String studentDni, int subjectId, int year) {
        return iCalificationsDao.findByStudentdniAndSubjectidAndYear(studentDni, subjectId, year);
    }

    @Override
    public List<Califications> findAllByStudentDniAndYear(String studentDni, int year) {
        return iCalificationsDao.findAllByStudentdniAndYear(studentDni, year);


    }

    @Override
    public void deleteCalification(String studentDni, int subjectId, int year) {
        iCalificationsDao.deleteCalificationsByStudentdniAndSubjectidAndYear(studentDni,subjectId,year);
    }

    @Override
    public void add(Califications newCalification) {
        iCalificationsDao.save(newCalification);
    }

}
