package com.Info.repository;

import com.Info.model.entity.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CommonRepository<Task, String> {
}
