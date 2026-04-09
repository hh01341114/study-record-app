package com.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dto.UserRequestDto;
import com.example.Dto.UserResponsDto;
import com.example.Service.UserManegementService;

/**
 * ユーザー認証用コントローラー
 */
@RestController
public class AuthController {
	// フィールド
	private final UserManegementService userManegementService;

	// コンストラクタ
	AuthController(UserManegementService userManegementService) {
		this.userManegementService = userManegementService;
	}

	/**
	 * ログイン
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public String getLogin() {

		return "login";
	}

	/**
	 * ユーザー登録 入力(RequestDTO)値を登録して出力(ResponsDTO)で返す
	 * 
	 * @param userRequestDto
	 * @return
	 */
	@PostMapping("/signup")
	public UserResponsDto createUser(@RequestBody UserRequestDto userRequestDto) {
		return userManegementService.createUser(userRequestDto);
	}

}