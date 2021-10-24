package com.ruben.estudiantes.entity.models.services;


import com.ruben.estudiantes.entity.models.Califications;
import com.ruben.estudiantes.entity.models.CalificationsPK;
import com.ruben.estudiantes.entity.models.dao.ICalificationsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CalificationsImpl implements  ICalifications {
    @Autowired
    ICalificationsDao iCalificationsDao;

    @Override
    public Optional<Califications> findByStudentDniAndSubjectIdAAndYears(String studentDni, int subjectId, int year) {
        return iCalificationsDao.findByStudentdniAndSubjectidAndYears(studentDni, subjectId, year);
    }

    @Override
    public List<Califications> findAllByStudentDniAndYears(String studentDni, int year) {
        return iCalificationsDao.findAllByStudentdniAndYears(studentDni, year);
    }

    @Override
    public void deleteCalification(String studentDni, int subjectId, int years) {
        CalificationsPK id = new CalificationsPK();
        id.setStudentdni(studentDni);
        id.setSubjectid(subjectId);
        id.setYears(years);
        iCalificationsDao.deleteById(id);
    }



    @Override
    @Transactional
    public void add(Califications calification) {
        iCalificationsDao.save(calification);
    }

    @Override
    public void update(Califications calification) {
        CalificationsPK calificationsPK=new CalificationsPK();
        calificationsPK.setYears(calification.getYears());
        calificationsPK.setStudentdni(calification.getStudentdni());
        calificationsPK.setSubjectid(calification.getSubjectid());

        if(iCalificationsDao.findById(calificationsPK).isPresent()){
            Califications oldCalification=iCalificationsDao.findById(calificationsPK).get();
            iCalificationsDao.deleteById(calificationsPK);
            oldCalification.setCalification(calification.getCalification());
            iCalificationsDao.save(oldCalification);
        }

    }

}
