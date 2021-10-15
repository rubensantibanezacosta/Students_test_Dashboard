package com.ruben.estudiantes.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruben.estudiantes.entity.models.Years;
import com.ruben.estudiantes.entity.models.services.IYears;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8100")
@RestController

public class YearsController {
    @Autowired
    IYears iYearsController;
    @GetMapping("/years")
    List<Years> getAll() {
        return iYearsController.getAll();
    }

    @PostMapping(value = "/years", consumes = "application/json")
    void add(@RequestBody String stringYear) {
        ObjectMapper om = new ObjectMapper();
        try {
            Years year = om.readValue(stringYear, Years.class);
            iYearsController.add(year);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/years/{year}")
    void delete(@PathVariable("year") int year) {
        iYearsController.delete(year);
    }
}
