package com.dimitris.tasks.mappers;

import com.dimitris.tasks.domain.dto.TaskListDto;
import com.dimitris.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);

}
