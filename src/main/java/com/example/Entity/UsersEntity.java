package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * ユーザーを管理するエンティティクラス
 */
@Entity
@Table(name = "users")
public class UsersEntity {
	
	/**
	 * user_id
	 * (自動採番)
	 */
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	/**
	 * email
	 * ログインID
	 */
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	
}