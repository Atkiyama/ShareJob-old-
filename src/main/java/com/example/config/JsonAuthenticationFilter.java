package com.example.config;

import java.io.IOException;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.form.LoginForm;
import com.example.service.UserDetailsService;
import com.example.service.impl.UserDetailsServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

private AuthenticationManager authenticationManager;


private UserDetailsService service;

public JsonAuthenticationFilter(AuthenticationManager authenticationManager){

    // AuthenticationManagerの設定
    this.authenticationManager = authenticationManager;

    // ログインパスを設定
    setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/api/login","POST"));
    // ログイン用パラメータの設定
    setUsernameParameter("userId");
    setPasswordParameter("password");

    // ログイン成功時はtokenを発行してレスポンスにセットする
    this.setAuthenticationSuccessHandler((req,res,ex) -> {
        // トークンの作成
        String token = JWT.create()
                .withIssuer("com.volkruss.toaru") //発行者
                .withClaim("userId", ex.getName()) //keyに対してvalueの設定。汎用的な様々な値を保持できる
                .sign(Algorithm.HMAC256("secret")); // 利用アルゴリズムを指定してJWTを新規作成
        res.setHeader("X-AUTH-TOKEN", token); // tokeをX-AUTH-TOKENというKeyにセットする
        res.setStatus(200);
    });

    // ログイン失敗時
    this.setAuthenticationFailureHandler((req,res,ex) -> {
        res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    });
}

@Override
public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
    try {
        ServletInputStream stream = request.getInputStream();
        // リクエストのjsonの値をUserFormにマッピングします。
        LoginForm form = new ObjectMapper().readValue(request.getInputStream(), LoginForm.class);
        service = new UserDetailsServiceImpl();
      
        // これでデフォルトのProviderを利用しつつ、ユーザーレコードの取得に関してはUserDetailsServiceの実装クラスのloadUserByUsernameを利用する
        UserDetails user = service.loadUserByUseId(form.getUserId());
        log.info("ユーザ="+user.toString());
        
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user, form.getPassword());
        token.setDetails(service);
        log.info("token="+token);
        return this.authenticationManager.authenticate(token);
    } catch (IOException e) {
        log.info("IOExexption発生");
        throw new RuntimeException(e);
    }
}
}