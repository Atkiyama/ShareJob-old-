package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.UserService;

@RestController
@RequestMapping("/index")
/**
 * Restを使ってプロフィール情報を返すコントローラー
 * RestはリクエストをhtmlではなくJSONで返す
 * 返す情報はStringで返してもいいしクラスの形でもOK
 * @author akiyamashuuhei
 *
 */
public class MainControlller {

	/**
	 * ユーザの情報を取得するサービスのクラス
	 */
	@Autowired
	private UserService userService;

	/**
	 * プロフィールの情報を返す。プロフィール情報は人によって違うのでリクエストするパラメータも人によって変わってくるので正規表現{userId:.+}
	 * を用いる
	 * nonLogindemoでは使用していない
	 * @param userId ユーザID リクエストに対応するものを自動で撮ってきてくれる
	 * @return json形式でユーザIDとパスワードが帰ってくる
	 */
	/*
	@GetMapping("/home")
	public MainViewMUser getUser(Model model, @PathVariable("userId") String userId) {
		//Muserをサービスから取得して返す
	    MUser mUser = userService.getUserOne(userId);
	    
	    MainViewMUser mvUser = new MainViewMUser(mUser);
		return mvUser;
	}
	*/
	
	

}
