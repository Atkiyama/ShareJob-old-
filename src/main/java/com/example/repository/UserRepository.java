package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.MUser;

/**
 * jpaを使って実装
 * クエリはほぼ教科書まんまでいいはず
 * @author akiyamashuuhei
 *
 * @author keigomatsumura
 * @date 2022/9/11
 *
 */
public interface UserRepository extends JpaRepository<MUser, String> {
    // ログインユーザ検索
    @Query("select user" + " from MUser user" + " where userId = :userId")
    public MUser findLoginUser(@Param("userId")String userId);

    // ユーザー更新
    @Modifying
    @Query("update MUser" + " set" + " password = :password" + ", userName = :userName" + " where" + " userId = :userId")
    public Integer updateUser(@Param("userId")String userId,
                              @Param("password")String password,
                              @Param("userName")String userName);
}
