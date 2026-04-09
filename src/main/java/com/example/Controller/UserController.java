package com.example.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.UserResponsDto;
import com.example.Dto.UserUpdateRequestDto;
import com.example.Service.UserManegementService;

/**
 * ユーザー情報のCRUD処理
 */
@RestController("/user")
public class UserController {

	private final UserManegementService userManegementService;

	public UserController(UserManegementService userManegementService) {
		this.userManegementService = userManegementService;
	}

	/**
	 * ユーザー情報を更新するメソッド
	 * 
	 * @param id
	 * @param userUpdateRequestDto
	 * @return
	 */
	@PatchMapping("/{id}")
	public UserResponsDto updateUser(@PathVariable Integer id, @RequestBody UserUpdateRequestDto userUpdateRequestDto) {
		return userManegementService.updateUser(id, userUpdateRequestDto);
	}

	/**
	 * ユーザー削除
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
		userManegementService.deleteUser(id);

		// 204 No Contentで返す
		return ResponseEntity.noContent().build();
	}
}