package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * ユーザ情報を定義するクラス
 * 今回は userId とpasswordだけでいい
 * @author akiyamashuuhei
 *
 * @author keigomatsumura
 * @date 2022/9/11
 *
 */
@Data
@Entity
@Table(name="m_user")
public class MUser {
    @Id
    private String userId;
    private String password;
    private String userName;
//    private String userName;
//    private Date birthday;
//    private Integer age;
//    private Integer gender;
//    private Integer departmentId;
//    private Grade grade;
//    @Transient
    //他対一
//    @ManyToOne(optional = true)
//    //外部キーを設定
//    @JoinColumn(insertable=false,updatable=false,name="company_Id")
//	private List<Company> companyList;
//    
//    @OneToOne(optional = true)
//    /*
//    //外部キー(複数)を設定
//    @JoinColumns({
//    	@JoinColumn(insertable=false,updatable=false,name="user_Id"),
//    	@JoinColumn(insertable=false,updatable=false,name="company_Id")
//    })*/
//    private Map<String,String> companyMemo;
}
