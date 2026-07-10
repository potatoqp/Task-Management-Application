package com.dimitris.tasks.repositories;

import com.dimitris.tasks.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;
import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> findByTaskListId(UUID taskListId);
    Optional<Task> findByTaskListIdAndId(UUID taskListId, UUID taskId);
    void deleteByTaskListIdAndId(UUID taskListId, UUID id);
}
