package com.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;
@Service

public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersMapper usersMapper;

	@Override
	@Transactional
	public void addUser(Users users) {

		if(users.getId()==1) {
			this.usersMapper.insertUser(users);
		}
		else{
			this.usersMapper.insertUser(users);
		}

	}

	@Override
	public List<Users> findUserAll() {
		return this.usersMapper.selectUsersAll();
	}

	@Override
	public Users findUserById(Integer id) {
		return this.usersMapper.selectUserById(id);
	}

	@Override
	public void editUser(Users users) {
		 usersMapper.editUser(users);

	}

}
