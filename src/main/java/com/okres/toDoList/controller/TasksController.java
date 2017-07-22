package com.okres.toDoList.controller;

import com.okres.toDoList.model.Task;
import com.okres.toDoList.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Alex on 21.07.2017.
 */
@Controller
public class TasksController {

    private TaskService taskService;

    @Autowired
    @Qualifier(value = "taskService")
    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public String listTasks(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("listTasks", this.taskService.listTasks());

        return "tasks";
    }

    @RequestMapping(value = "/tasks/add", method = RequestMethod.POST)
    public String addTask(@ModelAttribute("task") Task task) {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        task.setCreated(sqlDate);
        if (task.getPriority() > 5){
            task.setPriority(5);
        }
        if (task.getId() == 0) {
            this.taskService.addTask(task);
        } else {
            this.taskService.updateTask(task);
        }
        return "redirect:/tasks";
    }

    @RequestMapping("/remove/{id}")
    public String removeTask(@PathVariable("id") int id) {
        this.taskService.deleteTask(id);

        return "redirect:/tasks";
    }

    @RequestMapping("/edit/{id}")
    public String editTask(@PathVariable("id") int id, Model model) {
        model.addAttribute("task", this.taskService.getTaskById(id));
        model.addAttribute("list", this.taskService.listTasks());

        return "tasks";
    }

    @RequestMapping("taskdata/{id}")
    public String taskData(@PathVariable("id") int id, Model model) {
        model.addAttribute(this.taskService.getTaskById(id));

        return "taskdata";
    }


}
