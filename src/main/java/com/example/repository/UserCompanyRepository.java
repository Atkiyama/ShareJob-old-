package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.UserCompany;

public interface UserCompanyRepository extends JpaRepository<UserCompany, String> {

	@Query(value = "select *" + " from user_company" + " where userId = :userId",nativeQuery=true)
	List<UserCompany> findAllByUserId(@Param("userId")String userId);

}
