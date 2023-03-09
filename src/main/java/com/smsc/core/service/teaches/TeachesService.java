package com.smsc.core.service.teaches;

import com.smsc.core.model.Teaches;
import com.smsc.core.repository.TeachesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeachesService implements ITeachesService {

    @Autowired private TeachesRepository teachesRepository;

    @Override
    public List<Teaches> getAll() {
        return teachesRepository.findAll();
    }

    @Override
    public Teaches getOneById(Long teachesId) {
        return teachesRepository.findById(teachesId).orElse(null);
    }

    @Override
    public Teaches create(Teaches teaches) {
        return teachesRepository.save(teaches);
    }

    @Override
    public Teaches update(Teaches teaches) {
        return teachesRepository.saveAndFlush(teaches);
    }

    @Override
    public void delete(Long teachesId) {
        teachesRepository.deleteById(teachesId);
    }
}
