package com.example.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * ユーザーを管理するエンティティクラス
 */
@Entity
@Data
@Table(name = "users")
public class UsersEntity {

	/**
	 * user_id (自動採番)
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/**
	 * email ログインID
	 */
	@Column(name = "email", nullable = false, unique = true)
	private String email;

	/**
	 * password ログイン用パスワード
	 */
	@Column(name = "password", nullable = false)
	private String password;

	/**
	 * user_name ユーザーの名前
	 */
	@Column(name = "user_name", nullable = false)
	private String name;

	/**
	 * goal_short 短期的な目標
	 */
	@Column(name = "goal_short", columnDefinition = "TEXT")
	private String shortGoal;

	/**
	 * goal_long 長期的な目標
	 */
	@Column(name = "goal_long", columnDefinition = "TEXT")
	private String longGoal;

	/**
	 * created_at 作成日時
	 */
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createDateTime;

}