package com.ruben.estudiantes.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruben.estudiantes.entity.models.Subjects;
import com.ruben.estudiantes.entity.models.services.ISubjects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SubjectsController {
    @Autowired
    ISubjects iSubjectsService;
    @GetMapping("/subjects")
    List<Subjects> getAll() {
        return iSubjectsService.getAll();
    }

    @GetMapping("/subjects/{subjectId}")
    Subjects getOne(@PathVariable("subjectId") int subjectId) {
        Optional<Subjects> subject = iSubjectsService.getOne(subjectId);
        if (subject.isPresent()) {
            return subject.get();
        }
        return null;
    }

    @PostMapping(value = "/subjects", consumes = "application/json")
    void add(@RequestBody String stringSubject) {
        ObjectMapper om = new ObjectMapper();
        try {
            Subjects student = om.readValue(stringSubject, Subjects.class);
            iSubjectsService.add(student);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @PutMapping(value = "/subjects", consumes = "application/json")
    void update(@RequestBody String stringSubject) {
        ObjectMapper om = new ObjectMapper();
        try {
            Subjects newStudent = om.readValue(stringSubject, Subjects.class);
            iSubjectsService.update(newStudent);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/subjects/{subjectId}")
    void delete(@PathVariable("subjectId") int subjectId) {
        iSubjectsService.delete(subjectId);
    }

}
