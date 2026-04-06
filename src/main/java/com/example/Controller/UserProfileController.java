package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.Dto.UserResponsDto;
import com.example.Service.UserManegementService;

/**
 * ユーザー情報のコントローラー
 */
@Controller
@RequestMapping("/user")
public class UserProfileController {

	private final UserManegementService userManegementService;

	/**
	 * コンストラクタ
	 * 
	 * @param userManegementService
	 */
	public UserProfileController(UserManegementService userManegementService) {
		this.userManegementService = userManegementService;
	}

	/**
	 * ユーザー情報取得
	 * 
	 * @param id
	 * @return ユーザー情報
	 */
	@GetMapping("/profile/{id}")
	public UserResponsDto getUser(@PathVariable Integer id) {

		return userManegementService.findByUser(id);
	}
}