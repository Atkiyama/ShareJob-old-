package com.example.model.view;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Company;
import com.example.model.MUser;
import com.example.model.UserCompany;

import lombok.Data;

@Data
public class MainViewMUser {
	private String userName;
	/**
	 * キーに社名、valueにメモ
	 */
	private ArrayList<MainViewUserCompany> companyMemo;
	public MainViewMUser(MUser user,List<Company> companys, List<UserCompany> userCompanys) {
		// TODO 自動生成されたコンストラクター・スタブ
		userName = user.getUserName();
		companyMemo = new ArrayList<>();
		for(int i=0;i<companys.size();i++) {
			 companyMemo.add(new MainViewUserCompany(companys.get(i).getCompanyName(),userCompanys.get(i).getCompanyMemo()));
		}
	}

}
