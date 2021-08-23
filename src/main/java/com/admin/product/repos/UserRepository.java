package com.admin.product.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.product.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByUserNameAndPasswordAndStatus(String userName,String password,String status);

}
