package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Company;

/**
 * jpaを使って実装
 * クエリはほぼ教科書まんまでいいはず
 * @author akiyamashuuhei
 *
 * @author keigomatsumura
 * @date 2022/9/11
 *
 */
public interface CompanyRepository extends JpaRepository<Company, String> {
    // ログインユーザ検索
   ;
}
