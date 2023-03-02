package com.smsc.core.service.area;

import com.smsc.core.model.Area;
import com.smsc.core.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService implements IAreaService {

    @Autowired private AreaRepository areaRepository;

    @Override
    public List<Area> getAll() {
        return areaRepository.findAll();
    }

    @Override
    public Area getOneById(Long areaId) {
        return areaRepository.findById(areaId).orElse(null);
    }

    @Override
    public Area create(Area area) {
        return areaRepository.save(area);
    }

    @Override
    public Area update(Area area) {
        return areaRepository.saveAndFlush(area);
    }

    @Override
    public void delete(Long areaId) {
        areaRepository.deleteById(areaId);
    }
}
