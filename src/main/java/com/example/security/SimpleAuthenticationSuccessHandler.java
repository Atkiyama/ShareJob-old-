package com.example.security;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import lombok.extern.slf4j.Slf4j;

/**
 * 認証が成功した時の処理を実装したクラス
 */
@Slf4j
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
/**
 * 使用するアルゴリズムとキーをセットした値
 */
  final private Algorithm algorithm;

  /**
   * 秘密鍵の生成をするクラス
   * フィールドのアルゴリズムを用意する
   * @param secretKey
   */
  public SimpleAuthenticationSuccessHandler(String secretKey) {
    Objects.requireNonNull(secretKey, "secret key must be not null");
    this.algorithm = Algorithm.HMAC512(secretKey);
  }

  /**
   * トークンの持続時間
   */
  private static final Long EXPIRATION_TIME = TimeUnit.MINUTES.toMillis(10L);

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request,
                                      HttpServletResponse response,
                                      Authentication auth) {
    if (response.isCommitted()) {
      log.info("Response has already been committed.");
      return;
    }
    setToken(response, generateToken(auth));
    response.setStatus(HttpStatus.OK.value());
    clearAuthenticationAttributes(request);
  }

  /**
   * トークンを生成するメソッド
   * @param auth
   * @return
   */
  private String generateToken(Authentication auth) {
    LoginUser loginUser = (LoginUser) auth.getPrincipal();
    //日付を取得
    Date issuedAt = new Date();
    //トークンが使える開始時刻
    Date notBefore = new Date(issuedAt.getTime());
    //トークンの終了時刻
    Date expiresAt = new Date(issuedAt.getTime() + EXPIRATION_TIME);
    //トークン生成
    String token = JWT.create()
        .withIssuedAt(issuedAt)
        .withNotBefore(notBefore)
        .withExpiresAt(expiresAt)
        .withSubject(loginUser.getUser().getUserId().toString())
        .sign(this.algorithm);
    log.debug("generate token : {}", token);
    return token;
  }

  /**
   * 
   * レスポンスにトークンをセットするメソッド
   * @param response
   * @param token
   */
  private void setToken(HttpServletResponse response, String token) {
    response.setHeader("Authorization", String.format("Bearer %s", token));
  }

  /**
   * Removes temporary authentication-related data which may have been stored in the
   * session during the authentication process.
   * 
   * 認証処理中にセッションに保存された一時的な認証関連データを削除します。
   * 認証処理中にセッションに保存された可能性のある一時的な認証関連データを削除します。
   */
  private void clearAuthenticationAttributes(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    if (session == null) {
      return;
    }
    session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
  }

}
