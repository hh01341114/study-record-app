package com.example.ServiceImpl;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Dto.UserRequestDto;
import com.example.Dto.UserResponsDto;
import com.example.Dto.UserUpdateRequestDto;
import com.example.Entity.UsersEntity;
import com.example.Mapper.UserMapper;
import com.example.Repository.UserManagementRepository;
import com.example.Service.UserManegementService;

/**
 * ユーザー管理の処理実装
 */
@Service
public class UserManegementServiceImple implements UserManegementService {

	// フィールド
	private final UserManagementRepository userManagementRepository;
	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;

	// コンストラクタ
	public UserManegementServiceImple(UserManagementRepository userManagementRepository, UserMapper userMapper,
			PasswordEncoder passwordEncoder) {
		this.userManagementRepository = userManagementRepository;
		this.userMapper = userMapper;
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * ユーザー取得メソッド
	 */
	@Override
	public UserResponsDto findByUser(Integer id) {
		UsersEntity entity = userManagementRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ユーザーが見つかりません: id=" + id));
		return userMapper.toResponsDto(entity);
	}
	
	/**
	 * ユーザー作成時の作成時間登録とパスワードのハッシュ化
	 * 
	 * @param dto
	 * @return
	 */
	public UserResponsDto createUser(UserRequestDto dto) {
		UsersEntity entity = userMapper.toEntity(dto);
		// パスワードをエンコード化
		entity.setPassword(passwordEncoder.encode(dto.getPassword()));
		// 作成時間を取得
		entity.setCreateDateTime(LocalDateTime.now());
		// データ保存
		userManagementRepository.save(entity);

		return userMapper.toResponsDto(entity);
	}
	
	/**
	 * ユーザー情報更新
	 * @param id
	 * @param updateRequestDto
	 * @return ResponsDTOで返す	
	 */
	@Override
	public UserResponsDto updateUser(Integer id, UserUpdateRequestDto updateRequestDto) {
		UsersEntity entity = userManagementRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ユーザーが見つかりません: id=" + id));
		
		//更新処理
		userMapper.updateToEntity(updateRequestDto, entity);
		//データ保存
		userManagementRepository.save(entity);
		
		return userMapper.toResponsDto(entity);
	}
	
	/**
	 *ユーザーの削除
	 */
	@Override
	public void deleteUser(Integer id) {
		UsersEntity entity = userManagementRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("ユーザーが見つかりません: id=" + id));
		
		//データ保存
		userManagementRepository.delete(entity);
	}
}