package com.ruben.estudiantes.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruben.estudiantes.entity.models.Califications;
import com.ruben.estudiantes.entity.models.services.CalificationsImpl;
import com.ruben.estudiantes.entity.models.services.IStudents;
import com.ruben.estudiantes.entity.models.services.ISubjects;
import com.ruben.estudiantes.entity.models.services.IYears;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CalificationsController {

    @Autowired
    CalificationsImpl iCalificationService;


    @GetMapping("/califications/{dni}/{year}/{subjectId}")
    Califications getValue(@PathVariable("dni") String dni, @PathVariable("subjectId") int subjectId,
            @PathVariable("year") int year) {

        Optional<Califications> calification = iCalificationService.findByStudentDniAndSubjectIdAAndYears(dni, subjectId, year);
        if (calification.isPresent()) {
            return calification.get();
        }
        return null;
    }

    @GetMapping("/califications/{dni}/{year}")
    List<Califications> getValue(@PathVariable("dni") String dni, @PathVariable("year") int year) {

        return iCalificationService.findAllByStudentDniAndYears(dni, year);

    }
@Transactional
    @DeleteMapping(value = "/califications/{dni}/{year}/{subjectId}")
    void delete(@PathVariable("dni") String dni, @PathVariable("year") int year,
            @PathVariable("subjectId") int subjectId) {

        iCalificationService.deleteCalification(dni, subjectId, year);
    }
@Transactional
    @PostMapping(value = "/califications", consumes = "application/json")
    void add(@RequestBody String stringCalification) {
        System.out.println(stringCalification);
        ObjectMapper om = new ObjectMapper();
        try {
            Califications calification = om.readValue(stringCalification, Califications.class);
            iCalificationService.add(calification);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
/* 
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
    } */


}
