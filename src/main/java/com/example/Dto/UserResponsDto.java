package com.example.Dto;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * UserEntityの出力DTOクラス
 */
@Data
public class UserResponsDto {

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