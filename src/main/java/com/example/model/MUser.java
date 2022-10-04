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
//	private List<Company> salaryList;
}
