package com.dimitris.tasks.mappers;

import com.dimitris.tasks.domain.dto.TaskDto;
import com.dimitris.tasks.domain.entities.Task;

public interface TaskMapper {

   Task fromDto(TaskDto taskDto);

   TaskDto toDto(Task task);

}
