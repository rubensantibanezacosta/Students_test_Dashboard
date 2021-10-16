package com.ruben.estudiantes.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruben.estudiantes.entity.models.Califications;
import com.ruben.estudiantes.entity.models.services.ICalifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/califications")
@RestController
public class CalificationsController {
/*   @Autowired
    ICalifications iCalificationsService;

    @GetMapping("/califications")
    List<Califications> getAll() {
        return iCalificationsServiceDao.findAll();
    }

    @GetMapping("/califications/{subject_id}/{dni}/{year}")
    Califications getOne(@PathVariable("dni") int subject_id,@PathVariable("dni") String dni,@PathVariable("year") int year ){
        Optional<Califications> calification = iCalificationsService.getOne(new CalificationsPK(subject_id,dni,year));
        if (calification.isPresent()) {
            return calification.get();
        }
        return null;
    }

    @PostMapping(value = "/califications", consumes = "application/json")
    void add(@RequestBody String stringCalification) {
        ObjectMapper om = new ObjectMapper();
        try {
            Califications calification = om.readValue(stringCalification, Califications.class);
            iCalificationsService.add(calification);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @PutMapping(value = "/califications", consumes = "application/json")
    void update(@RequestBody String stringCalification) {
        ObjectMapper om = new ObjectMapper();
        try {
            Califications newCalification = om.readValue(stringCalification, Califications.class);
            iCalificationsService.update(newCalification);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/califications/{subject_id}/{dni}/{year}")
    void delete(@PathVariable("dni") int subject_id,@PathVariable("dni") String dni,@PathVariable("year") int year) {
        iCalificationsService.deleteById(new CalificationsPK(subject_id,dni,year));
    } */
}
