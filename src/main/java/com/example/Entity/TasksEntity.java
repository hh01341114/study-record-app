package com.example.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.example.Enum.PriorityEnum;
import com.example.Enum.StatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * タスクを管理するエンティティ
 */
@Entity
@Data
@Table(name = "task")
public class TasksEntity {

	/**
	 * タスクid
	 */
	@Id
	@Column(name = "task_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskId;

	/**
	 * ユーザーid 外部キー
	 */
	@ManyToOne
	@Column(name = "user_id", nullable = false)
	private UsersEntity user;
	
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
	private PriorityEnum priority;
	
	/**
	 * タスク状況
	 */
	@Column(name = "status", nullable = false, length = 20)
	private StatusEnum status;
	
	/**
	 * タスク作成時間
	 */
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
}