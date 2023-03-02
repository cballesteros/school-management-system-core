package com.smsc.core.service.grade;

import com.smsc.core.model.Grade;

import java.util.List;

public interface IGradeService {

    List<Grade> getAll();

    Grade getOneById(Long gradeId);

    Grade create(Grade grade);

    Grade update(Grade grade);

    void delete(Long gradeId);
}
