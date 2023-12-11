package com.Info.repository;

import com.Info.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<T extends BaseEntity, V> extends JpaRepository<T, V> {
}