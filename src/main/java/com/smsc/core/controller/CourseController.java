package com.smsc.core.controller;

import com.smsc.core.model.Course;
import com.smsc.core.service.course.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CourseController {
    
    @Autowired private CourseService courseService;

    @GetMapping
    public Course getOne(@Param("courseId") String courseId) {
        return courseService.getOneById(Long.parseLong(courseId));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    public Course create(@RequestBody Course course) {
        return courseService.create(course);
    }

    @PutMapping
    public Course update(@RequestBody Course course) {
        return courseService.update(course);
    }

    @DeleteMapping
    public void delete(@Param("courseId") String courseId) {
        courseService.delete(Long.parseLong(courseId));
    }
}
