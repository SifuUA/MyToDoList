package com.okres.toDoList.dao;

import com.okres.toDoList.model.Task;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alex on 21.07.2017.
 */

@Repository
public class TaskDaoImpl implements TaskDao {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(TaskDaoImpl.class);

    private SessionFactory sessionFactory;



    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addTask(Task task) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(task);
        logger.info("Task successfully added. Task info: " + task);
    }

    @Override
    public void updateTask(Task task) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(task);
        logger.info("Task successfully updated. Task info: " + task);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Task> listTasks() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Task> tasks = session.createQuery("from Task").list();

        for (Task task : tasks) {
            logger.info("Task list info: " + task);
        }
        return tasks;
    }

    @Override
    public Task getTaskById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Task task = (Task) session.load(Task.class, new Integer(id));
        logger.info("Task by id successfully get. Task info: " + task);
        return task;
    }

    @Override
    public void deleteTask(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Task task = (Task) session.load(Task.class, new Integer(id));
        if (task != null) {
            session.delete(task);
        }

        logger.info("Task succesfully deleted. Tasks info : " + task);
    }
}
