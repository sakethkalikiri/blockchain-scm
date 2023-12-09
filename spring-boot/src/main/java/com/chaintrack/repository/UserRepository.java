package com.chaintrack.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.chaintrack.modal.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByEmail(String email);

}
