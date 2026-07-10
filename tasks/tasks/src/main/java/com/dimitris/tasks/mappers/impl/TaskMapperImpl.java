package com.dimitris.tasks.mappers.impl;

import org.springframework.stereotype.Component;

import com.dimitris.tasks.domain.dto.TaskDto;
import com.dimitris.tasks.domain.entities.Task;
import com.dimitris.tasks.mappers.TaskMapper;



@Component
public class TaskMapperImpl implements TaskMapper {
    
    @Override
    public Task fromDto(TaskDto taskDto) {
       return new Task(
            taskDto.id(),
            null,
            taskDto.title(),
            taskDto.description(),
            taskDto.dueDate(),
            taskDto.status(),
            taskDto.priority(),
            null,
            null
       );
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getDueDate(),
            task.getPriority(),
            task.getStatus()
        );
    }

}

