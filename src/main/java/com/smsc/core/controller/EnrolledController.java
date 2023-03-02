package com.smsc.core.controller;

import com.smsc.core.model.Enrolled;
import com.smsc.core.service.enrolled.EnrolledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/enrolled")
@CrossOrigin(origins = "*", maxAge = 3600)
public class EnrolledController {

    @Autowired private EnrolledService enrolledService;

    @GetMapping
    public Enrolled getOne(@Param("enrolledId") String enrolledId) {
        return enrolledService.getOneById(Long.parseLong(enrolledId));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public List<Enrolled> getAll() {
        return enrolledService.getAll();
    }

    @PostMapping
    public Enrolled create(@RequestBody Enrolled enrolled) {
        return enrolledService.create(enrolled);
    }

    @PutMapping
    public Enrolled update(@RequestBody Enrolled enrolled) {
        return enrolledService.update(enrolled);
    }

    @DeleteMapping
    public void delete(@Param("enrolledId") String enrolledId) {
        enrolledService.delete(Long.parseLong(enrolledId));
    }
}
