package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Years;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearsImpl implements IYears{

    @Autowired IYears iyears;

    @Override
    public List<Years> getAll() {
        return iyears.getAll();
    }

    @Override
    public void add(Years year) {
        iyears.add(year);
    }



    @Override
    public void delete(int year) {
        iyears.delete(year);
    }
}
