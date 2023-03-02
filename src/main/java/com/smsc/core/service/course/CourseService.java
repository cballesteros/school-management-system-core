package com.smsc.core.service.course;

import com.smsc.core.model.Course;
import com.smsc.core.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements ICourseService {
    
    @Autowired private CourseRepository courseRepository;
    
    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course getOneById(Long courseId) {
        return courseRepository.findById(courseId).orElse(null);
    }

    @Override
    public Course create(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course update(Course course) {
        return courseRepository.saveAndFlush(course);
    }

    @Override
    public void delete(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
