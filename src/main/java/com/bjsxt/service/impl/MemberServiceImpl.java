package com.bjsxt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.MemberService;
@Service

public class MemberServiceImpl implements MemberService {
	@Autowired
	private UsersMapper usersMapper;

	@Override
	@Transactional
	public List<Users> getUser(Users users) {

		if(users.getId()==1) {
			usersMapper.insertUser(users);

			if("zhangsan".equals(users.getName())) {

				usersMapper.insertUser(users);

			}
		}
		else{
			usersMapper.insertUser(users);
		}


if(true) {
	System.out.println("aaaaaaaaaaaa:");
}

if(true) {
	System.out.println("aaaaaaaaaaaa:");
}



if(true) {

	if(true) {
		System.out.println("aaaaaaaaaaaa:");
	}

	if(true) {
		System.out.println("aaaaaaaaaaaa:");
	}

	System.out.println("aaaaaaaaaaaa:");
}



if(true) {
	System.out.println("aaaaaaaaaaaa:");
}


		List<Users> list = usersMapper.selectUserByIdName(users.getId(), users.getName());

		return list;

	}

	@Override
	public List<Users> findUserAll() {

		if(true) {
			System.out.println("aaaaaaaaaaaa:");
		}

		if(true) {
			System.out.println("aaaaaaaaaaaa:");
		}

		return this.usersMapper.selectUsersAll();
	}

	@Override
	public Users findUserById(Integer id) {

		if(true) {
			System.out.println("aaaaaaaaaaaa:");
		}

		if(true) {
			System.out.println("aaaaaaaaaaaa:");
		}

		return this.usersMapper.selectUserById(id);
	}

	@Override
	public void editUser(Users users) {

		if(true) {
			System.out.println("aaaaaaaaaaaa:");
		}

		if(true) {
			System.out.println("aaaaaaaaaaaa:");
		}

		 usersMapper.editUser(users);

	}

}
