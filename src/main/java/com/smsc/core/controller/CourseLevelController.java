package com.smsc.core.controller;

import com.smsc.core.model.CourseLevel;
import com.smsc.core.service.courselevel.CourseLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courselevel")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseLevelController {

    @Autowired private CourseLevelService courseLevelService;

    @GetMapping
    public CourseLevel getOne(@Param("courseLevelId") String courseLevelId) {
        return courseLevelService.getOneById(Long.parseLong(courseLevelId));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public List<CourseLevel> getAll() {
        return courseLevelService.getAll();
    }

    @PostMapping
    public CourseLevel create(@RequestBody CourseLevel courseLevel) {
        return courseLevelService.create(courseLevel);
    }

    @PutMapping
    public CourseLevel update(@RequestBody CourseLevel courseLevel) {
        return courseLevelService.update(courseLevel);
    }

    @DeleteMapping
    public void delete(@Param("courseLevelId") String courseLevelId) {
        courseLevelService.delete(Long.parseLong(courseLevelId));
    }
}
