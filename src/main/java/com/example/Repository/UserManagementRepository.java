package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.UsersEntity;

/**
 * ユーザー管理のリポジトリクラス
 */
@Repository
public interface UserManagementRepository extends JpaRepository<UsersEntity, Integer> {
}