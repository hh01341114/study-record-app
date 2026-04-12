package com.example.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * タスクを管理するエンティティ
 */
@Entity
@Table(name = "task")
public class TasksEntity {

	/**
	 * タスクid
	 */
	@Id
	@Column(name = "task_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;

	/**
	 * ユーザーid 外部キー
	 */
	@Column(name = "user_id", nullable = false)
	private int userId;
	
	/**
	 * タスクタイトル
	 */
	@Column(name = "title", nullable = false, length = 100)
	private String title;
	
	/**
	 * タスク内容
	 */
	@Column(name = "detail", columnDefinition = "TEXT")
	private String detail;
	
	/**
	 * 期限
	 */
	@Column(name = "due_date")
	private LocalDate dueDate;
	
	/**
	 * 重要度
	 */
	@Column(name = "priority", nullable = false, length = 20)
	private String priority;
	
	/**
	 * タスク状況
	 */
	@Column(name = "status", nullable = false, length = 20)
	private String status;
	
	/**
	 * タスク作成時間
	 */
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
}