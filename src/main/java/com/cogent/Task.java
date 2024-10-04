package com.cogent;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task {

    @Id
    private int taskId;

    private String description;

    private Category category;

    private boolean isCompleted;



    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + taskId +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", isCompleted=" + isCompleted +
                '}';
    }
}

