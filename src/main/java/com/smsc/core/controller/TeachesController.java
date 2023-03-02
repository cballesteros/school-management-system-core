package com.smsc.core.controller;

import com.smsc.core.model.Teaches;
import com.smsc.core.service.teaches.TeachesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/teaches")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TeachesController {

    @Autowired private TeachesService teachesService;

    @GetMapping
    public Teaches getOne(@Param("teachesId") String teachesId) {
        return teachesService.getOneById(Long.parseLong(teachesId));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public List<Teaches> getAll() {
        return teachesService.getAll();
    }

    @PostMapping
    public Teaches create(@RequestBody Teaches teaches) {
        return teachesService.create(teaches);
    }

    @PutMapping
    public Teaches update(@RequestBody Teaches teaches) {
        return teachesService.update(teaches);
    }

    @DeleteMapping
    public void delete(@Param("teachesId") String teachesId) {
        teachesService.delete(Long.parseLong(teachesId));
    }
}
