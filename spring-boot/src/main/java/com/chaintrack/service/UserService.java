package com.chaintrack.service;

import com.chaintrack.exception.UserException;
import com.chaintrack.modal.User;

public interface UserService {
	
	public User findUserById(Long userId) throws UserException;
	
	public User findUserProfileByJwt(String jwt) throws UserException;

}
