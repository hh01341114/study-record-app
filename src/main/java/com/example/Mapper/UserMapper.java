package com.example.Mapper;

import org.springframework.stereotype.Component;

import com.example.Dto.UserRequestDto;
import com.example.Dto.UserResponsDto;
import com.example.Entity.UsersEntity;

/**
 * ユーザー情報のマッパークラス UserEntity → ResponsDto RequestDto → UserEntity
 */
@Component
public class UserMapper {

	/**
	 * DTOにマッピング
	 * @param entity
	 * @return dto
	 */
	public UserResponsDto toResponsDto(UsersEntity entity) {
		UserResponsDto dto = new UserResponsDto();
		//EntityからDTOに変換
		dto.setName(entity.getName());
		dto.setEmail(entity.getEmail());
		dto.setShortGoal(entity.getShortGoal());
		dto.setLongGoal(entity.getLongGoal());
		dto.setCreateDateTime(entity.getCreateDateTime());		
		
		return dto;
	}
	
	/**
	 * Entityにマッピング
	 * @param dto
	 * @return entity
	 */
	public UsersEntity toEntity(UserRequestDto requestDto) {
		UsersEntity entity = new UsersEntity();
		//DTOからEntityに変換
		entity.setName(requestDto.getName());
		entity.setEmail(requestDto.getEmail());
		entity.setPassword(requestDto.getPassword());
		entity.setShortGoal(requestDto.getShortGoal());
		entity.setLongGoal(requestDto.getLongGoal());
		
		return entity;
	}
}