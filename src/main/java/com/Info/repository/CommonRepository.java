package com.Info.repository;

import com.Info.model.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CommonRepository<E extends BaseEntity<V>, V> extends JpaRepository<E, V> {
}
