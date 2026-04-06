package com.example.ServiceImpl;

import org.springframework.stereotype.Service;

import com.example.Dto.UserResponsDto;
import com.example.Entity.UsersEntity;
import com.example.Mapper.UserMapper;
import com.example.Repository.UserManagementRepository;
import com.example.Service.UserManegementService;

/**
 * ユーザー管理の処理実装
 */
@Service
public class UserManegementServiceImple implements UserManegementService {
	//TODO(パスワードのエンコードとマッピング)
	//TODO(作成時間のマッピング)
	
	private final UserManagementRepository userManagementRepository;
	private final UserMapper userMapper;
	
	/**
	 * コンストラクタ
	 * @param userManagementRepository
	 * @param userMapper
	 */
	public UserManegementServiceImple(UserManagementRepository userManagementRepository, UserMapper userMapper) {
		this.userManagementRepository = userManagementRepository;
		this.userMapper = userMapper;
	}
	
	/**
	 *ユーザー取得メソッド
	 */
	@Override
	public UserResponsDto findByUser(Integer id) {
		UsersEntity entity = userManagementRepository.findById(id)
				 .orElseThrow(() -> new RuntimeException("ユーザーが見つかりません: id=" + id));
		return userMapper.toResponsDto(entity);
	}
	
}