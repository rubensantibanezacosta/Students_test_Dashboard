package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Califications;
import com.ruben.estudiantes.entity.models.CalificationsPK;
import com.ruben.estudiantes.entity.models.dao.ICalificationsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalificationsImpl implements  ICalifications{
    @Autowired ICalificationsDao iCalificationsDao;
    @Override
    public List<Califications> getAll() {
        return (List<Califications>) iCalificationsDao.findAll();
    }

    @Override
    public Optional<Califications> getOne(CalificationsPK calificationsPK) {
        return iCalificationsDao.findById(calificationsPK);
    }




    @Override
    public void add(Califications califications) {
        iCalificationsDao.save(califications);
    }

    @Override
    public void update(Califications newCalification) {
        CalificationsPK calificationsPK = new CalificationsPK(newCalification.getSubjectId(), newCalification.getStudentDni(), newCalification.getYear());

        Optional<Califications> oldCalification = iCalificationsDao.findById(calificationsPK);
        if (oldCalification.isPresent()) {
            oldCalification.get().setCalification(oldCalification.get().getCalification());
            iCalificationsDao.save(oldCalification.get());
        }
    }

    @Override
    public void deleteById (CalificationsPK calificationPK) {
        iCalificationsDao.deleteById(calificationPK);
    }

}
