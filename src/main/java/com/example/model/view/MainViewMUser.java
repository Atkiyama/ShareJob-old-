package com.example.model.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.MUser;
import com.example.model.UserCompany;

import lombok.Data;

@Data
public class MainViewMUser {
	private String userName;
	/**
	 * キーに社名、valueにメモ
	 */
	private Map<String, String> companyMemo;
	public MainViewMUser(MUser user,List<UserCompany> userCompany) {
		// TODO 自動生成されたコンストラクター・スタブ
		userName = user.getUserName();
		companyMemo = new HashMap<>();
		for(UserCompany mUserCompany:userCompany) {
			 companyMemo.put(mUserCompany.getMUserCompanyKey().getCompanyId(),mUserCompany.getCompanyMemo());
		}
	}

}
