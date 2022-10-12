package com.example.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.LoginForm;
import com.example.model.MUser;
import com.example.model.view.MainViewMUser;
import com.example.service.UserService;

/**
 * ログイン画面に遷移するためのコントローラー
 * "/sharejob"に飛ぶようにしてください
 * @author akiyamashuuhei
 *
 */
@RestController
@RequestMapping("index")
public class LoginController {
	

	/**
	 * ユーザの情報を取得するサービスのクラス
	 */
    
	@Autowired
	private UserService userService;

	/**
	 * プロフィールの情報を返す。プロフィール情報は人によって違うのでリクエストするパラメータも人によって変わってくるので正規表現{userId:.+}
	 * を用いる
	 * @param userId ユーザID リクエストに対応するものを自動で撮ってきてくれる
	 * @return json形式でユーザIDとパスワードが帰ってくる
	 */
	@PostMapping("/login")
	public MainViewMUser postLogin(Model model, Locale locale, @ModelAttribute LoginForm form,BindingResult bindingResult) {
		//IDに合致するMuserをサービスから取得
		MUser user = userService.getUserOne(form.getUserId());
		MainViewMUser mvUser = new MainViewMUser(user);
		return mvUser;
	        
	}


}
