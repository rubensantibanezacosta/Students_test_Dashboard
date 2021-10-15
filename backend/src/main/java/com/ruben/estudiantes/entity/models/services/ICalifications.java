package com.ruben.estudiantes.entity.models.services;

import com.ruben.estudiantes.entity.models.Califications;
import com.ruben.estudiantes.entity.models.CalificationsPK;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public interface ICalifications  {
    public List<Califications> getAll();
    public Optional<Califications> getOne(CalificationsPK calificationsPK);

    List<Califications> getAllByDni(String dni);

    public void add(Califications califications);
    public void update(Califications califications);
    public void deleteById(CalificationsPK calificationPK);
}
