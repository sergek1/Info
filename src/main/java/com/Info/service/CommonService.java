package com.Info.service;

import com.Info.model.entity.BaseEntity;
import com.Info.repository.CommonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public abstract class CommonService<T extends BaseEntity, V> {

    protected final CommonRepository<T, V> commonRepository;

    public void add(T entity) {
        commonRepository.saveAndFlush(entity);
    }

    public List<T> getAll() {
        return commonRepository.findAll();
    }

    public void deleteById(V id) {
        commonRepository.deleteById(id);
    }

    public T findById(V id) {
        return commonRepository.findById(id).orElse(null);
    }

}

