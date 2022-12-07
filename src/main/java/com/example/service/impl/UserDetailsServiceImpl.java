package com.example.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.MUser;
import com.example.repository.UserRepository;
import com.example.service.UserDetailsService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUseId(String userId) throws UsernameNotFoundException {
        try{
            Optional<MUser> option = userRepository.findById(userId);
            MUser entity = option.orElse(null);
            log.info("entity="+entity.getUserId());
            // 認可があればここで設定できる
            // org.springframework.security.core.userdetails.Userにして返却する
            // パスワードエンコーダを利用してパスワードはエンコードをかける
            return new User(entity.getUserId(), entity.getPassword(), new ArrayList<>());
        }catch (Exception e) {
            
            throw new UsernameNotFoundException("ユーザーが見つかりません");
        }
    }
}