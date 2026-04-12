package com.example.Dto;

import java.time.LocalDate;

import com.example.Enum.PriorityEnum;
import com.example.Enum.StatusEnum;
import com.sun.istack.NotNull;

import lombok.Data;

/**
 * タスク作成用のDTO
 */
@Data
public class TasksCreateRequestDto {

	/**
	 * タスクのタイトル
	 */
	@NotNull
	private String title;
	
	/**
	 * 内容
	 */
	private String detail;
	
	/**
	 * 期限
	 */
	private LocalDate dueDate;
	
	/**
	 * 重要度
	 */
	@NotNull
	private PriorityEnum priority;
	
	/**
	 * タスク状況
	 */
	@NotNull
	private StatusEnum status;
	
}