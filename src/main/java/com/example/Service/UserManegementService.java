package com.example.Service;

import com.example.Dto.UserResponsDto;

/**
 * ユーザー管理のインターフェース
 */
public interface UserManegementService {

	UserResponsDto findByUser(Integer id);

}