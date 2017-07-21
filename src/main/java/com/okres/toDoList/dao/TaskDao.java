package com.okres.toDoList.dao;

import com.okres.toDoList.model.Task;

import java.util.List;

/**
 * Created by Alex on 21.07.2017.
 */
public interface TaskDao {
    public void addTask(Task task);
    public void updateTask(Task task);
    public List<Task> listTasks();
    public Task getTaskById(int id);
    public void deleteTask(int id);
}
