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

@RequestMapping(value = "/subjects")
@CrossOrigin(origins = "http://127.0.0.1:8100")
@RestController
public class SubjectsController {
    @Autowired
    ISubjects iSubjectsService;
    @GetMapping("/subjects")
    List<Subjects> getAll() {
        return iSubjectsService.getAll();
    }

    @GetMapping("/subjects/{subject_id}")
    Subjects getOne(@PathVariable("subject_id") int subject_id) {
        Optional<Subjects> subject = iSubjectsService.getOne(subject_id);
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

    @DeleteMapping("/subjects/{subject_id}")
    void delete(@PathVariable("subject_id") int subject_id) {
        iSubjectsService.delete(subject_id);
    }

}
