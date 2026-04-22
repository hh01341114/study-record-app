package com.example.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.TasksEntity;
import com.example.Entity.UsersEntity;

/**
 * タスク用リポジトリ
 */
@Repository
public interface TasksRepository extends JpaRepository<TasksEntity, Integer> {

	/**
	 * ユーザーに紐づくタスク
	 * 
	 * @param user
	 * @param taskId
	 * @return
	 */
	Optional<TasksEntity> findByUserAndTaskId(UsersEntity user, Integer taskId);

	/**
	 * ログインユーザー紐付け
	 * 
	 * @param user
	 * @param pageable
	 * @return
	 */
	Page<TasksEntity> findByUser(UsersEntity user, Pageable pageable);
}