package com.smsc.core.service.courselevel;

import com.smsc.core.model.CourseLevel;
import com.smsc.core.repository.CourseLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseLevelService implements ICourseLevelService {

    @Autowired private CourseLevelRepository courseLevelRepository;

    @Override
    public List<CourseLevel> getAll() {
        return courseLevelRepository.findAll();
    }

    @Override
    public CourseLevel getOneById(Long courseLevelId) {
        return courseLevelRepository.findById(courseLevelId).orElse(null);
    }

    @Override
    public CourseLevel create(CourseLevel courseLevel) {
        return courseLevelRepository.save(courseLevel);
    }

    @Override
    public CourseLevel update(CourseLevel courseLevel) {
        return courseLevelRepository.saveAndFlush(courseLevel);
    }

    @Override
    public void delete(Long courseLevelId) {
        courseLevelRepository.deleteById(courseLevelId);
    }
}
