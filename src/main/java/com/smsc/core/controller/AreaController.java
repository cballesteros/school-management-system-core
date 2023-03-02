package com.smsc.core.controller;

import com.smsc.core.model.Area;
import com.smsc.core.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/area")
@CrossOrigin(origins = "*", maxAge = 3600)
public class AreaController {

    @Autowired private AreaService areaService;

    @GetMapping
    public Area getOne(@Param("areaId") String areaId) {
        return areaService.getOneById(Long.parseLong(areaId));
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMINISTRATOR')")
    public List<Area> getAll() {
        return areaService.getAll();
    }

    @PostMapping
    public Area create(@RequestBody Area area) {
        return areaService.create(area);
    }

    @PutMapping
    public Area update(@RequestBody Area area) {
        return areaService.update(area);
    }

    @DeleteMapping
    public void delete(@Param("areaId") String areaId) {
        areaService.delete(Long.parseLong(areaId));
    }

}
