package com.dimitris.tasks.services;

import com.dimitris.tasks.domain.entities.Task;
import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface TaskService {
    List<Task> listTasks(UUID taskListId);
    Task createTask(UUID taskListId, Task task);
    Optional<Task> getTask(UUID taskListId,UUID taskId);
    Task updateTask(UUID taskListId, UUID taskId, Task task);
    void deleteTask(UUID taskListId, UUID taskId);
}
