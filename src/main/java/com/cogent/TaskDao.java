package com.cogent;

import java.util.List;

public interface TaskDao {
    void addTask(Task task);
    void updateTask(Task task);

    void deleteTask(int deleteId);

    List<Task> getAllTasks();

}
