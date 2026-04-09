package com.example.Service;

import com.example.Dto.UserRequestDto;
import com.example.Dto.UserResponsDto;
import com.example.Dto.UserUpdateRequestDto;

/**
 * ユーザー管理のインターフェース
 */
public interface UserManegementService {

	/**
	 * ユーザー作成
	 * @param id
	 * @return
	 */
	UserResponsDto createUser(UserRequestDto dto);
	
	/**
	 * ユーザー取得
	 * @param id
	 * @return
	 */
	UserResponsDto findByUser(Integer id);
	
	/**
	 * ユーザー情報更新
	 * @param id
	 * @return
	 */
	UserResponsDto updateUser(Integer id, UserUpdateRequestDto updateRequestDto);
	
	/**
	 * ユーザー削除
	 * @param id
	 * @return
	 */
	void deleteUser(Integer id);

}