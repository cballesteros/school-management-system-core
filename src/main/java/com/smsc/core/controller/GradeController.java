package com.smsc.core.controller;

import com.smsc.core.model.Grade;
import com.smsc.core.service.grade.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grade")
@CrossOrigin(origins = "*", maxAge = 3600)
public class GradeController {

    @Autowired private GradeService courseLevelService;

    @GetMapping
    public Grade getOne(@Param("gradeId") String gradeId) {
        return courseLevelService.getOneById(Long.parseLong(gradeId));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public List<Grade> getAll() {
        return courseLevelService.getAll();
    }

    @PostMapping
    public Grade create(@RequestBody Grade grade) {
        return courseLevelService.create(grade);
    }

    @PutMapping
    public Grade update(@RequestBody Grade grade) {
        return courseLevelService.update(grade);
    }

    @DeleteMapping
    public void delete(@Param("gradeId") String gradeId) {
        courseLevelService.delete(Long.parseLong(gradeId));
    }
}
