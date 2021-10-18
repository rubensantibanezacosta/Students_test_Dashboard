package com.ruben.estudiantes.controllers;

import com.ruben.estudiantes.entity.models.Califications;

import com.ruben.estudiantes.entity.models.services.ICalifications;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CalificationsController {

    @Autowired
    private ICalifications iCalification;

    @GetMapping("/califications/{dni}/{subjectId}/{year}")
    Califications getValue(@PathVariable("dni") String dni, @PathVariable("subjectId") int subjectId,
            @PathVariable("year") int year) {
        System.out.println(dni);
        System.out.println(subjectId);
        System.out.println(year);

        Optional<Califications> calification = iCalification.findByStudentDniAndSubjectIdAAndYear(dni, subjectId, year);
        if (calification.isPresent()) {
            return calification.get();
        }
        return null;
    }

    /*
     * @PostMapping(value = "/califications", consumes = "application/json") void
     * add(@RequestBody String stringCalification) { ObjectMapper om = new
     * ObjectMapper(); try { Califications calification =
     * om.readValue(stringCalification, Califications.class);
     * iCalificationsService.add(calification); } catch (JsonMappingException e) {
     * e.printStackTrace(); } catch (JsonProcessingException e) {
     * e.printStackTrace(); } }
     * 
     * @PutMapping(value = "/califications", consumes = "application/json") void
     * update(@RequestBody String stringCalification) { ObjectMapper om = new
     * ObjectMapper(); try { Califications newCalification =
     * om.readValue(stringCalification, Califications.class);
     * iCalificationsService.update(newCalification); } catch (JsonMappingException
     * e) { e.printStackTrace(); } catch (JsonProcessingException e) {
     * e.printStackTrace(); } }
     * 
     * @DeleteMapping("/califications/{subjectId}/{dni}/{year}") void
     * delete(@PathVariable("dni") int subjectId,@PathVariable("dni") String
     * dni,@PathVariable("year") int year) { iCalificationsService.deleteById(new
     * CalificationsPK(subjectId,dni,year)); }
     */
}
