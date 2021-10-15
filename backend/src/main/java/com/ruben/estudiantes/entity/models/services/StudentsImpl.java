package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsImpl implements  IStudents{
    @Autowired
    IStudents iStudents;
    @Override
    public List<Students> getAll() {
        return iStudents.getAll();
    }

    @Override
    public Optional<Students> getOne(String dni) {
        return iStudents.getOne(dni);
    }

    @Override
    public void add(Students student) {
        iStudents.add(student);
    }

    @Override
    public void update(Students newStudent) {
        Optional<Students> oldStudent =  iStudents.getOne(newStudent.getDni());
        if(oldStudent.isPresent()){
            oldStudent.get().setName(newStudent.getName());
            oldStudent.get().setSurname(newStudent.getSurname());
            iStudents.add(oldStudent.get());
        }
    }

    @Override
    public void delete(String dni) {

    }
}
