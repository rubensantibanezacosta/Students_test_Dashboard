package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Subjects;
import com.ruben.estudiantes.entity.models.dao.ISubjectsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectsImpl implements ISubjects{
   @Autowired ISubjectsDao iSubjectsDao;
    @Override
    public List<Subjects> getAll() {
        return (List<Subjects>) iSubjectsDao.findAll();
    }

    @Override
    public Optional<Subjects> getOne(int subjectId) {

        return iSubjectsDao.findById(subjectId);
    }

    @Override
    public void add(Subjects subject) {
        iSubjectsDao.save(subject);

    }

    @Override
    public void update(Subjects newSubject) {
        Optional<Subjects> oldSubject = iSubjectsDao.findById(newSubject.getSubjectId());
        if(oldSubject.isPresent()) {
            oldSubject.get().setName(newSubject.getName());
            iSubjectsDao.save(oldSubject.get());
        }
    }

    @Override
    public void delete(int subjectId) {
        iSubjectsDao.deleteById(subjectId);
    }
}
