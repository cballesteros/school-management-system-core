package com.smsc.core.service.level;

import com.smsc.core.model.Level;

import java.util.List;

public interface ILevelService {

    List<Level> getAll();

    Level getOneById(Long levelId);

    Level create(Level level);

    Level update(Level level);

    void delete(Long levelId);
}
