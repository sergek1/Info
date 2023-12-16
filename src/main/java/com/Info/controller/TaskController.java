package com.Info.controller;

import com.Info.model.entity.Task;
import com.Info.service.CommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private static final Logger log = LoggerFactory.getLogger(TaskController.class);

    @Autowired
    private CommonService<Task, Long> taskCommonService;

    @GetMapping()
    public String tasks(Model model) throws SQLException {
        List<Task> tasksList = taskCommonService.getAll();
        model.addAttribute("tasks", tasksList);
        return "tasks";
    }


    @PostMapping("/add")
    public String addCheck(
            @RequestParam("taskTitle") String taskTitle,
            @RequestParam(name = "parentTaskId", required = false) Long parentTaskId,
            @RequestParam("maxXp") Integer maxXp
    ) {
        System.out.println("============================ parentTaskTitle=" + parentTaskId + " maxXp=" + maxXp);
        Task parentTask = null;
        if (parentTaskId != null) {
            parentTask = taskCommonService.findById(parentTaskId);
        }
        Task task = new Task();
        task.setTitle(taskTitle);
        task.setParentTask(parentTask);
        task.setMaxXp(maxXp);
        taskCommonService.add(task);
        return "redirect:/tasks";
    }


    @PostMapping("/update")
    public String update(
            @RequestParam("id") Long id,
            @RequestParam("updatedTitle") String title,
            @RequestParam("parentTaskId") Long parentTaskId,
            @RequestParam("updatedMaxXp") Integer maxXp
    ) {
        Task existingTask = taskCommonService.findById(id);
        if (existingTask != null) {
            Task task = taskCommonService.findById(parentTaskId);
            existingTask.setTitle(title);
            existingTask.setParentTask(task);
            existingTask.setMaxXp(maxXp);
            taskCommonService.add(existingTask);
        } else {
            System.out.println("update not executed");
        }

        return "redirect:/tasks";
    }

    @PostMapping("/delete")
    public String delete(
            @RequestParam("id") Long id
    ) {
        taskCommonService.deleteById(id);
        return "redirect:/tasks";
    }
}
