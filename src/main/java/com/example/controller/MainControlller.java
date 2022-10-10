package com.example.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.MainForm;
import com.example.model.MUser;
import com.example.model.view.MainViewMUser;
import com.example.service.UserService;

@RestController
@RequestMapping("/api")
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
	@GetMapping("/index")
	public MUser getUser(Model model, @PathVariable("userId") String userId) {
		//Muserをサービスから取得して返す
		return userService.getUserOne(userId);
	}
	
	@PostMapping("/home")
    public MainViewMUser postLogin(Model model, Locale locale, @ModelAttribute MainForm form,BindingResult bindingResult) {
        //IDに合致するMuserをサービスから取得
        MUser user = userService.getUserOne(form.getUserId());
        //jsonで返すためにMainViewMUserに変換
       
      //jsonで返すためにMainViewMUserに変換
        MainViewMUser mvuser = new MainViewMUser(user);
        return mvuser;
    }

}
