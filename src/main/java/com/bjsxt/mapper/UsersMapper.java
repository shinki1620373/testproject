package com.bjsxt.mapper;

import java.util.List;

import com.bjsxt.pojo.Users;

public interface UsersMapper {

	void insertUser(Users users);

	List<Users> selectUsersAll();
	Users selectUserById(Integer id);

	void  editUser(Users users);

	List<Users> selectUserByIdName(Integer id, String name);

}
