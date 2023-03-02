package com.smsc.core.service.teaches;

import com.smsc.core.model.Teaches;

import java.util.List;

public interface ITeachesService {

    List<Teaches> getAll();

    Teaches getOneById(Long teachesId);

    Teaches create(Teaches teaches);

    Teaches update(Teaches teaches);

    void delete(Long teachesId);
}
