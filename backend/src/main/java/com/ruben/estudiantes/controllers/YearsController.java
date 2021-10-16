package com.ruben.estudiantes.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ruben.estudiantes.entity.models.Years;
import com.ruben.estudiantes.entity.models.services.IYears;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200")

public class YearsController {
    @Autowired
    IYears iYearsService;


    @GetMapping("/years")
    List<Years> findAll() {
        return iYearsService.findAll();
    }
    
    @PostMapping(value = "/years", consumes = "application/json")
    void add(@RequestBody String stringYear) {
        ObjectMapper om = new ObjectMapper();
        try {
            Years year = om.readValue(stringYear, Years.class);
            iYearsService.add(year);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/years/{year}")
    void delete(@PathVariable("year") int year) {
        iYearsService.delete(year);
    }
}
