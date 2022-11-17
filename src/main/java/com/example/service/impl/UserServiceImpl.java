package com.example.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.model.MUser;
import com.example.repository.UserRepository;
import com.example.service.UserService;

/**
 * 13章を参照
 * @author akiyamashuuhei
 *
 * @author keigomatsumura
 * @date 2022/9/11
 *
 */
@Service
@Primary
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    /*
    @Autowired
    private PasswordEncoder encoder;
    */
    //ユーザ登録
    @Transactional
    @Override
    public void signUp(MUser user) {
        // 存在チェック
        boolean exists = repository.existsById(user.getUserId());
        if(exists){
            throw new DataAccessException("ユーザが既に存在"){};
        }

//        user.setDepartmentId(1);
//        user.setRole("Role_GENERAL");

      

        // insert
        repository.save(user);
    }

    // ユーザ取得
    @Override
    public List<MUser> getUsers(MUser user) {
        return repository.findAll();
    }

    // ユーザ取得（１件）
    @Override
    public MUser getUserOne(String userId) {
        Optional<MUser> option = repository.findById(userId);
        MUser user = option.orElse(null);
        return user;
    }

    // ユーザ更新
    @Transactional
    @Override
    public void updateUserOne(String userId, String password, String userName) {

    }

    // ユーザー削除（１件）
    @Transactional
    @Override
    public void deleteUserOne(String userId, String password, String userName) {
        repository.deleteById(userId);
    }

    // ログインユーザ取得
    @Override
    public MUser getLoginUser(String userId) {
        Optional<MUser> option = repository.findById(userId);
        MUser user = option.orElse(null);
        return user;
    }

}
