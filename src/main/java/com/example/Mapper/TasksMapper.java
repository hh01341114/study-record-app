package com.example.Mapper;

import org.springframework.stereotype.Component;

import com.example.Dto.TasksCreateRequestDto;
import com.example.Dto.TasksResponsDto;
import com.example.Dto.TasksUpdateRequestDto;
import com.example.Entity.TasksEntity;

/**
 * タスク管理マッピング
 */
@Component
public class TasksMapper {
	
	/**
	 * DTOにマッピング
	 * @param tasksCreateRequestDto
	 * @return
	 */
	public TasksResponsDto toTasksDto(TasksCreateRequestDto tasksCreateRequestDto) {
		TasksResponsDto tasksResponsDto = new TasksResponsDto();
		
		tasksResponsDto.setTitle(tasksCreateRequestDto.getTitle());
		tasksResponsDto.setDetail(tasksCreateRequestDto.getDetail());
		tasksResponsDto.setDueDate(tasksCreateRequestDto.getDueDate());
		tasksResponsDto.setPriority(tasksCreateRequestDto.getPriority());
		tasksResponsDto.setStatus(tasksCreateRequestDto.getStatus());
		
		return tasksResponsDto;
	}

	/**
	 * DTOからEntityへマッピング
	 * 
	 * @param tasksCreateRequestDto
	 * @return
	 */
	public TasksEntity toTasksEntity(TasksCreateRequestDto tasksCreateRequestDto) {
		TasksEntity tasksEntity = new TasksEntity();

		tasksEntity.setTitle(tasksCreateRequestDto.getTitle());
		tasksEntity.setDetail(tasksCreateRequestDto.getDetail());
		tasksEntity.setDueDate(tasksCreateRequestDto.getDueDate());
		tasksEntity.setPriority(tasksCreateRequestDto.getPriority());
		tasksEntity.setStatus(tasksCreateRequestDto.getStatus());

		return tasksEntity;
	}

	/**
	 * タスク更新情報をエンティティにマッピング
	 * 
	 * @param tasksEntity
	 * @param tasksUpdateRequestDto
	 */
	public void updateTask(TasksEntity tasksEntity, TasksUpdateRequestDto tasksUpdateRequestDto) {
		tasksEntity.setTitle(tasksUpdateRequestDto.getTitle());
		tasksEntity.setDueDate(tasksUpdateRequestDto.getDueDate());
		tasksEntity.setPriority(tasksUpdateRequestDto.getPriority());
		tasksEntity.setStatus(tasksUpdateRequestDto.getStatus());
	}
}