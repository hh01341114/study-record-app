package com.example.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.TasksCreateRequestDto;
import com.example.Dto.TasksResponsDto;
import com.example.Dto.TasksUpdateRequestDto;
import com.example.Entity.UsersEntity;
import com.example.Service.TasksService;

/**
 * タスク管理用コントローラー
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {

	private final TasksService tasksService;

	// コンストラクタ
	public TaskController(TasksService tasksService) {
		this.tasksService = tasksService;
	}

	/**
	 * タスク取得
	 * 
	 * @param user
	 * @return
	 */
	@GetMapping("/{taskId}")
	public TasksResponsDto getTask(@AuthenticationPrincipal UsersEntity user, @PathVariable Integer taskId) {

		return tasksService.getTaskDetail(user, taskId);
	}

	/**
	 * タスク一覧取得（ページング）
	 * 
	 * @param user
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<TasksResponsDto> getTaskList(@AuthenticationPrincipal UsersEntity user,
			@PageableDefault(size = 10) Pageable pageable) {

		return tasksService.getTaskList(user, pageable);
	}

	/**
	 * タスク作成
	 * 
	 * @param user
	 * @param tasksCreateRequestDto
	 * @return
	 */
	@PostMapping
	public TasksResponsDto creatTask(@AuthenticationPrincipal UsersEntity user,
			@RequestBody TasksCreateRequestDto tasksCreateRequestDto) {

		return tasksService.createTask(user, tasksCreateRequestDto);
	}

	/**
	 * タスク更新
	 * 
	 * @param user
	 * @param tasksUpdateRequestDto
	 * @param taskId
	 * @return
	 */
	@PutMapping("/{taskId}")
	public TasksResponsDto updateTask(@AuthenticationPrincipal UsersEntity user,
			@RequestBody TasksUpdateRequestDto tasksUpdateRequestDto, @PathVariable Integer taskId) {

		return tasksService.updateTask(user, tasksUpdateRequestDto, taskId);
	}

	/**
	 * タスク削除
	 * 
	 * @param user
	 * @param taskId
	 */
	@DeleteMapping("/{taskId}")
	public void deleteTask(@AuthenticationPrincipal UsersEntity user, @PathVariable Integer taskId) {
		tasksService.deleteTask(user, taskId);
	}
}