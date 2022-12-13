package com.example.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/**
 * パスワードを暗号化するためのクラス
 * 主に仮IDを生成するのに使うので動作には影響しない
 * @author akiyamashuuhei
 *
 */
public class PasswordMaker {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encoded = "id4";
		System.out.println(encoder.encode(encoded));


	}

}
