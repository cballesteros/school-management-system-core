package com.smsc.core.service.enrolled;

import com.smsc.core.model.Enrolled;
import com.smsc.core.repository.EnrolledRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EnrolledService implements IEnrolledService {

    @Autowired private EnrolledRepository enrolledRepository;

    @Override
    public List<Enrolled> getAll() {
        return enrolledRepository.findAll();
    }

    @Override
    public Enrolled getOneById(Long enrolledId) {
        return enrolledRepository.findById(enrolledId).orElse(null);
    }

    @Override
    public Enrolled create(Enrolled enrolled) {
        return enrolledRepository.save(enrolled);
    }

    @Override
    public Enrolled update(Enrolled enrolled) {
        return enrolledRepository.saveAndFlush(enrolled);
    }

    @Override
    public void delete(Long enrolledId) {
        enrolledRepository.deleteById(enrolledId);
    }
}
