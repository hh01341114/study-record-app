package com.example.Dto;

import java.time.LocalDate;

import com.example.Enum.PriorityEnum;
import com.example.Enum.StatusEnum;

import lombok.Data;

/**
 * タスク更新用DTO
 */
@Data
public class TasksUpdateRequestDto {

	/**
	 * タスクのタイトル 任意
	 */
	private String title;

	/**
	 * 期限 任意
	 */
	private LocalDate dueDate;

	/**
	 * 重要度 任意
	 */
	private PriorityEnum priority;

	/**
	 * タスク状況 任意
	 */
	private StatusEnum status;
}