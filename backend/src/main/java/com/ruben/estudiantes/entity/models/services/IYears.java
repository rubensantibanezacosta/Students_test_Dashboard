package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Years;
import java.util.List;

public interface IYears {
    public List<Years> findAll();
    public void add(Years year);
    public void delete(int year);
}
