package com.example.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Dto.TasksCreateRequestDto;
import com.example.Dto.TasksResponsDto;
import com.example.Dto.TasksUpdateRequestDto;
import com.example.Entity.TasksEntity;
import com.example.Entity.UsersEntity;
import com.example.Mapper.TasksMapper;
import com.example.Repository.TasksRepository;
import com.example.Service.TasksService;
import com.example.exception.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class TasksServiceImpl implements TasksService {

	private final TasksRepository tasksRepository;

	private final TasksMapper tasksMapper;

	// コンストラクタ
	public TasksServiceImpl(TasksRepository tasksRepository, TasksMapper tasksMapper) {
		this.tasksRepository = tasksRepository;
		this.tasksMapper = tasksMapper;
	}

	/**
	 * タスク作成
	 * 
	 * @param tasksCreateRequestDto
	 * @return
	 */
	@Transactional
	@Override
	public TasksResponsDto createTask(UsersEntity user, TasksCreateRequestDto tasksCreateRequestDto) {
		TasksEntity tasksEntity = tasksMapper.toTasksEntity(tasksCreateRequestDto);
		// ログインユーザーの紐付け
		tasksEntity.setUser(user);

		tasksRepository.save(tasksEntity);

		return tasksMapper.toTasksDto(tasksEntity);
	}

	/**
	 * ログインユーザーのタスクを取得
	 * 
	 * @param taskId
	 * @param id
	 * @return
	 */
	@Override
	public TasksResponsDto getTaskDetail(UsersEntity user, Integer taskId) {
		// タスクが存在しない場合
		TasksEntity tasksEntity = tasksRepository.findByUserAndTaskId(user, taskId)
				.orElseThrow(() -> new ResourceNotFoundException("タスクが見つかりません: taskId=" + taskId));

		return tasksMapper.toTasksDto(tasksEntity);
	}
	
	/**
	 * タスク一覧取得
	 * @param user
	 * @return task一覧
	 */
	List<TasksResponsDto> getTaskList(UsersEntity user) {
		//ログインユーザー紐付け
		List<TasksEntity> tasks = tasksRepository.findByUser(user);
		
		return tasks.stream()
				.map(tasksMapper::toTasksDto)
				.toList();
	}

	/**
	 * タスク更新処理
	 * 
	 * @param user
	 * @param tasksUpdateRequestDto
	 * @param taskId
	 * @return
	 */
	@Transactional
	@Override
	public TasksResponsDto updateTask(UsersEntity user, TasksUpdateRequestDto tasksUpdateRequestDto, Integer taskId) {
		// タスクが存在しない場合
		TasksEntity tasksEntity = tasksRepository.findByUserAndTaskId(user, taskId)
				.orElseThrow(() -> new ResourceNotFoundException("タスクが見つかりません: taskId=" + taskId));

		tasksMapper.updateTask(tasksEntity, tasksUpdateRequestDto);

		return tasksMapper.toTasksDto(tasksEntity);
	}

	@Transactional
	@Override
	public void deleteTask(UsersEntity user, Integer taskId) {
		// タスクが存在しない場合
		TasksEntity tasksEntity = tasksRepository.findByUserAndTaskId(user, taskId)
				.orElseThrow(() -> new ResourceNotFoundException("タスクが見つかりません: taskId=" + taskId));

		tasksRepository.delete(tasksEntity);
	}

}