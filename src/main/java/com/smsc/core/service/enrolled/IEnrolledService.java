package com.smsc.core.service.enrolled;

import com.smsc.core.model.Enrolled;

import java.util.List;

public interface IEnrolledService {

    List<Enrolled> getAll();

    Enrolled getOneById(Long enrolledId);

    Enrolled create(Enrolled enrolled);

    Enrolled update(Enrolled enrolled);

    void delete(Long enrolledId);
}
