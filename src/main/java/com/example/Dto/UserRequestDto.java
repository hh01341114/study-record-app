package com.example.Dto;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * UsersEntityの入力DTOクラス
 */
@Data
public class UserRequestDto {
	/**
	 * ユーザーID
	 */
	private Integer id;

	/**
	 * ユーザー名
	 */
	private String name;

	/**
	 * email ログインID
	 */
	private String email;
	
	/**
	 * password
	 */
	private String password;

	/**
	 * 短期目標
	 */
	private String shortGoal;

	/**
	 * 長期目標
	 */
	private String longGoal;

	/**
	 * 作成時間
	 */
	private LocalDateTime createDateTime;
}