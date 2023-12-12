package com.Info.service;

import com.Info.model.entity.BaseEntity;
import com.Info.repository.CommonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class CommonService<E extends BaseEntity<V>, V> {

    protected final CommonRepository<E, V> commonRepository;

    public void add(E entity) {
        commonRepository.saveAndFlush(entity);
    }

    public List<E> getAll() {
        return commonRepository.findAll();
    }

    public void deleteById(V id) {
        commonRepository.deleteById(id);
    }

    public E findById(V id) {
        return commonRepository.findById(id).orElse(null);
    }

}

