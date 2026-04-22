package com.example.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.Enum.PriorityEnum;
import com.example.Enum.StatusEnum;

import lombok.Data;

@Data
public class TasksResponsDto {

	/**
	 * タスクid
	 */
	private int taskId;

	/**
	 * タスクのタイトル
	 */
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
	private PriorityEnum priority;

	/**
	 * タスク状況
	 */
	private StatusEnum status;

	/**
	 * 作成時間
	 */
	private LocalDateTime createdAt;
}