package com.smsc.core.service.level;

import com.smsc.core.model.Level;
import com.smsc.core.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LevelService implements ILevelService {

    @Autowired private LevelRepository levelRepository;

    @Override
    public List<Level> getAll() {
        return levelRepository.findAll();
    }

    @Override
    public Level getOneById(Long levelId) {
        return levelRepository.findById(levelId).orElse(null);
    }

    @Override
    public Level create(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public Level update(Level level) {
        return levelRepository.saveAndFlush(level);
    }

    @Override
    public void delete(Long levelId) {
        levelRepository.deleteById(levelId);
    }
}
