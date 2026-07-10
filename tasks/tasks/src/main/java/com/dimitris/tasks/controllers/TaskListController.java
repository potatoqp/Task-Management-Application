package com.dimitris.tasks.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import com.dimitris.tasks.domain.dto.TaskListDto;
import com.dimitris.tasks.services.TaskListService;
import com.dimitris.tasks.mappers.TaskListMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.dimitris.tasks.domain.entities.TaskList;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping(path = "/api/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }



    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTaskLists()
        .stream()
        .map(taskListMapper::toDto)
        .toList();
    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdTaskList = taskListService.createTaskList(
            taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(createdTaskList);
    }


    @GetMapping("/{taskListId}")
    public Optional<TaskListDto> getTaskList(@PathVariable UUID taskListId) {
        return taskListService.getTaskList(taskListId).map(taskListMapper::toDto);
    }

    @PutMapping(path = "/{taskListId}")
    public TaskListDto updateTaskList(
        @PathVariable UUID taskListId,
        @RequestBody TaskListDto taskListDto) {
        TaskList updatedTaskList = taskListService.updateTaskList(
            taskListId, 
            taskListMapper.fromDto(taskListDto));

        return taskListMapper.toDto(updatedTaskList);
    }

    @DeleteMapping(path = "/{task_list_id}")
    public void deleteTaskList(@PathVariable("task_list_id") UUID taskListId) {
        taskListService.deleteTaskList(taskListId);
    }
    
}
