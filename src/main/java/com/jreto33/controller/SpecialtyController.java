package com.jreto33.controller;

import com.jreto33.modelo.SpecialtyModel;
import com.jreto33.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Specialty")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SpecialtyController {
    @Autowired
    private SpecialtyService specialtyService;

    @GetMapping("/all")
    public List<SpecialtyModel> getAllSpecialties() {
        return specialtyService.getAllSpecialties();
    }

    @GetMapping("/{id}")
    public Optional<SpecialtyModel> getSpecialty(@PathVariable Integer id) {
        return specialtyService.getSpecialty(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public SpecialtyModel saveSpecialty(@RequestBody SpecialtyModel specialtyModel) {
        return specialtyService.saveSpecialty(specialtyModel);
    }

    @DeleteMapping("/delete/{id}")   // /{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteSpecialty(@PathVariable Integer id) {
        return specialtyService.deleteSpecialty(id);
    }

    @PutMapping("update")
    @ResponseStatus(HttpStatus.CREATED)
    public SpecialtyModel updateSpecialty(@RequestBody SpecialtyModel specialtyModel) {
        return specialtyService.updateSpecialty(specialtyModel);
    }
}
