package com.smsc.core.controller;

import com.smsc.core.model.Level;
import com.smsc.core.service.level.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/level")
@CrossOrigin(origins = "*", maxAge = 3600)
public class LevelController {

    @Autowired
    private LevelService levelService;

    @GetMapping
    public Level getOne(@Param("levelId") String levelId) {
        return levelService.getOneById(Long.parseLong(levelId));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public List<Level> getAll() {
        return levelService.getAll();
    }

    @PostMapping
    public Level create(@RequestBody Level level) {
        return levelService.create(level);
    }

    @PutMapping
    public Level update(@RequestBody Level level) {
        return levelService.update(level);
    }

    @DeleteMapping
    public void delete(@Param("levelId") String levelId) {
        levelService.delete(Long.parseLong(levelId));
    }
}
