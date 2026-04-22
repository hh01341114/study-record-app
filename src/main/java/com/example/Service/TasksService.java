package com.example.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.Dto.TasksCreateRequestDto;
import com.example.Dto.TasksResponsDto;
import com.example.Dto.TasksUpdateRequestDto;
import com.example.Entity.UsersEntity;

/**
 * タスクインターフェースクラス
 */
public interface TasksService {
	
	/**
	 * タスク作成
	 * @param user
	 * @param tasksCreateRequestDto
	 * @return
	 */
	TasksResponsDto createTask(UsersEntity user, TasksCreateRequestDto tasksCreateRequestDto);
	
	/**
	 * タスク取得
	 * 
	 * @param user
	 * @param taskId
	 * @return
	 */
	TasksResponsDto getTaskDetail(UsersEntity user, Integer taskId);
	
	/**
	 * タスクリスト取得
	 * @param user
	 * @return
	 */
	Page<TasksResponsDto> getTaskList(UsersEntity user, Pageable pageable);

	/**
	 * タスク更新
	 * @param user
	 * @param tasksUpdateRequestDto
	 * @param taskId
	 * @return
	 */
	TasksResponsDto updateTask(UsersEntity user, TasksUpdateRequestDto tasksUpdateRequestDto, Integer taskId);

	/**
	 * タスク削除
	 * @param user
	 * @param taskId
	 */
	void deleteTask(UsersEntity user, Integer taskId);
}