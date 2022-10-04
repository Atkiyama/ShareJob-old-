package com.example.form;

import java.util.HashMap;

import lombok.Data;

@Data
public class MainForm {
	String userName;
	
	/**
	 * キーに会社名、valueにメモの内容をセット
	 * hashmapがどのような形でjsonで帰ってくるかは以下リンクを参照
	 * https://www.delftstack.com/ja/howto/java/how-to-convert-hashmap-to-json-object-in-java/
	 */
	HashMap<String,String> companyMemo;

}
