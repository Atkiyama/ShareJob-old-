package com.example.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.SignUpForm;
import com.example.model.MUser;
import com.example.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/index")
/**
 * Restを使ってプロフィール情報を返すコントローラー
 * RestはリクエストをhtmlではなくJSONで返す
 * 返す情報はStringで返してもいいしクラスの形でもOK
 * @author akiyamashuuhei
 *
 */
@Slf4j

public class SignUpController {

	/**
	 * ユーザの情報を取得するサービスのクラス
	 */
	@Autowired
	private UserService userService;
	
	 

	@PostMapping("/signUp")
    public String postSignUp(Model model, Locale locale, @ModelAttribute SignUpForm form,BindingResult bindingResult) throws NoSuchAlgorithmException {
        //IDに合致するMuserをサービスから取得
	    String userName = form.getUserName();
	    String password = form.getPassword();
	    String userId = getHash(userName);
	    log.info("form "+form.toString());
	    
	    MUser user = new MUser(userId,password,userName);
	    userService.signUp(user);
     
        return userId;
            
    }
	
	public String getTimeStamp() {
	    
	    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String str = timestamp.toString();
        //log.info("タイムスタンプ"+str);
        str = str.replace("-", "").replace(":", "").replace(".", "").replace(" ", "");
        log.info("タイムスタンプ"+str);
        return str;
	}
	public String getHash(String userName) throws NoSuchAlgorithmException {
	    MessageDigest md = MessageDigest.getInstance("SHA-256");
	    String plainText = userName + getTimeStamp();
	    //log.info("userName "+userName);
	    log.info("ハッシュ化前"+plainText);
        byte[] bt =  md.digest(plainText.getBytes());    
        String str = bt.toString();
        log.info("ハッシュ化後"+str);
        String match = "[^\uAC00-\uD7A30-9a-zA-Z\\s]";
        
        str = str.replaceAll(match,"").replace(" ", "");
        log.info("完成品"+str);
        return str;
	}
	
	
	

}
