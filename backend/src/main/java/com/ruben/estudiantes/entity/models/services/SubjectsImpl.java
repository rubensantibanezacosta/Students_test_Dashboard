package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Subjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectsImpl implements ISubjects{
   @Autowired ISubjects iSubjects;
    @Override
    public List<Subjects> getAll() {
        return iSubjects.getAll();
    }

    @Override
    public Optional<Subjects> getOne(int subject_id) {

        return iSubjects.getOne(subject_id);
    }

    @Override
    public void add(Subjects subject) {
        iSubjects.add(subject);

    }

    @Override
    public void update(Subjects newSubject) {
        Optional<Subjects> oldSubject = iSubjects.getOne(newSubject.getIdSubject());
        if(oldSubject.isPresent()) {
            oldSubject.get().setName(newSubject.getName());
            iSubjects.add(oldSubject.get());
        }
    }

    @Override
    public void delete(int subject_id) {
        iSubjects.delete(subject_id);
    }
}
