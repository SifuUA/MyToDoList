package com.okres.toDoList.model;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Alex on 21.07.2017.
 */
@Entity
@Table(name = "list")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "created")
    private Date created;

    @Column(name = "prority")
    private int priority;

    @Column(name = "due_date")
    private Date dueDate;

    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", created=" + created +
                ", priority=" + priority +
                ", dueDate=" + dueDate +
                '}';
    }
}
