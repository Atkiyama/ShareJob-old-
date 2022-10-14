package com.example.model.view;

import com.example.model.MUser;

import lombok.Data;

@Data
public class MainViewMUser {
	private String userName;
	/**
	 * キーに社名、valueにメモ
	 */
//	private Map<String, String> companyMemo;
	public MainViewMUser(MUser user) {
		// TODO 自動生成されたコンストラクター・スタブ
		userName = user.getUserName();
//		companyMemo = user.getCompanyMemo();
	}

}
