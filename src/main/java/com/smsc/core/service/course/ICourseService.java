package com.smsc.core.service.course;

import com.smsc.core.model.Course;

import java.util.List;

public interface ICourseService {
    
    List<Course> getAll();

    Course getOneById(Long courseId);

    Course create(Course course);

    Course update(Course course);

    void delete(Long courseId);
}
