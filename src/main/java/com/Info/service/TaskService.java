package com.Info.service;

import com.Info.model.entity.Task;
import com.Info.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService extends CommonService<Task, Long> {

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        super(taskRepository);
    }
}
