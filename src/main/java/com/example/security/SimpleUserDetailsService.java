package com.example.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.repository.UserRepository;

/**
 * Userエンティティ
 */
public class SimpleUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    SimpleUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) {
        // emailでデータベースからユーザーエンティティを検索する
        return userRepository.findByEmail(email)
                .map(LoginUser::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }

}
