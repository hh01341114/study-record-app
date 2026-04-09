package com.example.Dto;

import lombok.Data;

/**
 * ユーザー情報更新DTOクラス
 */
@Data
public class UserUpdateRequestDto {

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
}