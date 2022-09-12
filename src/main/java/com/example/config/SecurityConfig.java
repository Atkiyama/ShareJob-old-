package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /** セキュリティの対象外を設定 */
    @Override
    public void configure(WebSecurity web) throws Exception {
        // セキュリティを適用しない
        web
            .ignoring()
                .antMatchers("/webjars/**")
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/h2-console/**");
    }
    
    /** 認証の設定 */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder encoder = passwordEncoder();
        // インメモリ認証
        /*
        auth
            .inMemoryAuthentication()
                .withUser("user") // userを追加
                    .password(encoder.encode("user"))
                    .roles("GENERAL")
                .and()
                .withUser("admin") // adminを追加
                    .password(encoder.encode("admin"))
                    .roles("ADMIN");
        */

        // ユーザーデータ認証
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(encoder);
    }
}

