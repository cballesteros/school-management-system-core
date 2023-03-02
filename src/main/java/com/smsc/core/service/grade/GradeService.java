package com.smsc.core.service.grade;

import com.smsc.core.model.Grade;
import com.smsc.core.repository.GradeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GradeService implements IGradeService {

    @Autowired private GradeRepository gradeRepository;

    @Override
    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }

    @Override
    public Grade getOneById(Long gradeId) {
        return gradeRepository.findById(gradeId).orElse(null);
    }

    @Override
    public Grade create(Grade grade) {
        return gradeRepository.save(grade);
    }

    @Override
    public Grade update(Grade grade) {
        return gradeRepository.saveAndFlush(grade);
    }

    @Override
    public void delete(Long gradeId) {
        gradeRepository.deleteById(gradeId);
    }
}
