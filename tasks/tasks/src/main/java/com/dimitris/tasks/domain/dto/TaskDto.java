package com.dimitris.tasks.domain.dto;
import java.util.UUID;
import java.time.LocalDateTime;
import com.dimitris.tasks.domain.entities.TaskPriority;
import com.dimitris.tasks.domain.entities.TaskStatus;

public record TaskDto(
    UUID id,
    String title,
    String description,
    LocalDateTime dueDate,
    TaskPriority priority,
    TaskStatus status
) {

}
