package org.manoj.javaminds.dao;

import org.manoj.javaminds.entity.UserDetails;

public interface UserDAO {

	public void addUserDetails(UserDetails userDetails) throws Exception;

	public UserDetails getUserDetails(Integer userId) throws Exception;
}
