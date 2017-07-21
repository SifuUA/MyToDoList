package com.okres.toDoList.service;

import com.okres.toDoList.dao.TaskDao;
import com.okres.toDoList.model.Task;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Alex on 21.07.2017.
 */
@Service
public class TaskServiceImpl implements TaskService {

    private TaskDao taskDao;

    public void setTaskDao(TaskDao taskDao) {
        this.taskDao = taskDao;
    }

    @Override
    @Transactional
    public void addTask(Task task) {
        this.taskDao.addTask(task);
    }

    @Override
    @Transactional
    public void updateTask(Task task) {
        this.taskDao.updateTask(task);
    }

    @Override
    @Transactional
    public List<Task> listTasks() {
        return this.taskDao.listTasks();
    }

    @Override
    @Transactional
    public Task getTaskById(int id) {
        return this.taskDao.getTaskById(id);
    }

    @Override
    @Transactional
    public void deleteTask(int id) {
        this.taskDao.deleteTask(id);
    }
}
