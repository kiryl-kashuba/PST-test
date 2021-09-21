package com.kashuba.simplewebapp.service;

import java.util.List;
import java.util.Optional;

public interface Crud<T> {

    Long create(T t);

    void delete(Long id);

    List<T> getAll();

    Optional<T> get(Long id);
}
