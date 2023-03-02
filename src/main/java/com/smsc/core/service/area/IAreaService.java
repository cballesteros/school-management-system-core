package com.smsc.core.service.area;

import com.smsc.core.model.Area;

import java.util.List;

public interface IAreaService {

    List<Area> getAll();

    Area getOneById(Long areaId);

    Area create(Area area);

    Area update(Area area);

    void delete(Long areaId);
}
