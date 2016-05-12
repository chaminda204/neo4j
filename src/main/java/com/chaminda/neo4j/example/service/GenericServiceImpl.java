package com.chaminda.neo4j.example.service;

import org.springframework.data.neo4j.repository.GraphRepository;


public class GenericServiceImpl<T> implements GenericService<T> {

    private GraphRepository<T> repository;

    public GenericServiceImpl(GraphRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public T save(T entity) {
        return repository.save(entity);
    }

    @Override
    public Iterable<T> findAll() {
        return repository.findAll();
    }

    @Override
    public T findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    protected GraphRepository<T> getRepository() {
        return repository;
    }

}
