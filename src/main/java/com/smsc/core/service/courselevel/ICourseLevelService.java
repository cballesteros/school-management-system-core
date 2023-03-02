package com.smsc.core.service.courselevel;

import com.smsc.core.model.CourseLevel;

import java.util.List;

public interface ICourseLevelService {

    List<CourseLevel> getAll();

    CourseLevel getOneById(Long courseLevelId);

    CourseLevel create(CourseLevel courseLevel);

    CourseLevel update(CourseLevel courseLevel);

    void delete(Long courseLevelId);
}
