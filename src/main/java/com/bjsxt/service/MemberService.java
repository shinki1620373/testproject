package com.bjsxt.service;

import java.util.List;

import com.bjsxt.pojo.Users;

public interface MemberService {

	List<Users> getUser(Users users);
	List<Users> findUserAll();
	Users findUserById(Integer id);
	void editUser(Users users);


}
