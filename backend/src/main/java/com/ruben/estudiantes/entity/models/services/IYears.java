package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Years;
import java.util.List;
import java.util.Optional;

public interface IYears {
    public List<Years> findAll();

    public Optional<Years> getOne(int year);
    public void add(Years year);
    public void delete(int year);
}
