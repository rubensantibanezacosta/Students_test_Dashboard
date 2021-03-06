package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Years;
import com.ruben.estudiantes.entity.models.dao.IYearsDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class YearsImpl implements IYears{

    @Autowired IYearsDao iyearsDao;

    @Override
    public List<Years> findAll() {
        return (List<Years>) iyearsDao.findAll();
    }

    @Override
    public Optional<Years> getOne(int year) {
        return iyearsDao.findById(year);
    }

    @Override
    public void add(Years year) {
        iyearsDao.save(year);
    }



    @Override
    public void delete(int year) {
        iyearsDao.deleteById(year);
    }
}
