package com.chaminda.neo4j.example.service;

public interface GenericService<T> {

    T save(T entity);

    Iterable<T> findAll();

    T findOne(Long id);

    void delete(Long id);

}
