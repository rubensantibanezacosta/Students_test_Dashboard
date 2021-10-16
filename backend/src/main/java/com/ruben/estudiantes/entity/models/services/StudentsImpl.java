package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Students;
import com.ruben.estudiantes.entity.models.dao.IStudentsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsImpl implements IStudents{
    @Autowired
    IStudentsDao iStudentsDao;


    @Override
    public List<Students> getAll() {
        return (List<Students>) iStudentsDao.findAll();
    }

    @Override
    public Optional<Students> getOne(String dni) {
        return iStudentsDao.findById(dni);
    }

    @Override
    public void add(Students student) {
        iStudentsDao.save(student);
    }

    @Override
    public void update(Students newStudent) {
        Optional<Students> oldStudent =  iStudentsDao.findById(newStudent.getDni());
        if(oldStudent.isPresent()){
            oldStudent.get().setName(newStudent.getName());
            oldStudent.get().setSurname(newStudent.getSurname());
            iStudentsDao.save(oldStudent.get());
        }
    }

    @Override
    public void delete(String dni) {

    }
}
