package com.ruben.estudiantes.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruben.estudiantes.entity.models.Students;
import com.ruben.estudiantes.entity.models.services.IStudents;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8100")
@RestController
public class StudentsController {
    @Autowired
    IStudents iStudentsService;

    @GetMapping("/students")
    List<Students> getAll() {
        return iStudentsService.getAll();
    }

    @GetMapping("/students/{dni}")
    Students getOne(@PathVariable("dni") String dni) {
        Optional<Students> student = iStudentsService.getOne(dni);
        if (student.isPresent()) {
            return student.get();
        }
        return null;
    }

    @PostMapping(value = "/students", consumes = "application/json")
    void add(@RequestBody String stringStudent) {
        ObjectMapper om = new ObjectMapper();
        try {
            Students student = om.readValue(stringStudent, Students.class);
            iStudentsService.add(student);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @PutMapping(value = "/students", consumes = "application/json")
    void update(@RequestBody String stringStudent) {
        ObjectMapper om = new ObjectMapper();
        try {
            Students newStudent = om.readValue(stringStudent, Students.class);
            iStudentsService.update(newStudent);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/students/{dni}")
    void delete(@PathVariable("dni") String dni) {
        iStudentsService.delete(dni);
    }
}
