package com.example.service;

import java.util.List;

import com.example.model.MUser;

/**
 * 本の8.2.1を参照
 * @author akiyamashuuhei
 *
 */
public interface UserService {
    // ユーザー登録
   // public void signup(MUser user);

    // ユーザ取得
    public List<MUser> getUsers(MUser user);
    

    public MUser getUserOne(String userId);

    public void updateUserOne(String userId, String password, String userName);

    public void deleteUserOne(String userId, String password, String userName);

    public MUser getLoginUser(String userId);
}
