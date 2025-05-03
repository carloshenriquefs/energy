package br.com.fiap.energy.service;

import java.util.List;

public interface ServiceAdapter<T, R> {

    T save(R r);
    T findById(Long id);
    List<T> findAll();
    void delete(Long id);
}
