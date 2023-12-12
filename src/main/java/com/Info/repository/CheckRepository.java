package com.Info.repository;

import com.Info.model.entity.Check;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckRepository extends CommonRepository<Check, Long> {
}
