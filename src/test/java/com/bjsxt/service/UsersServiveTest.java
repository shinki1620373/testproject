package com.bjsxt.service;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bjsxt.mapper.UsersMapper;
import com.bjsxt.pojo.Users;
import com.bjsxt.service.impl.UsersServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class UsersServiveTest {
	@InjectMocks
	UsersServiceImpl service;
	@Mock
	UsersMapper usersMapper;

	/*
	 * id=1 case
	 */
	@Test
	public void test_addUserId2() {
		Users users = new Users();
		users.setName("zhang");
		users.setId(1);
		users.setAge(28);
		service.addUser(users);
	}

	@Test
	public void test_findUserAll() {
		List<Users> expectUsersList= new ArrayList();
		Users users = new Users();
		expectUsersList.add(users);//?
		when(usersMapper.selectUsersAll()).thenReturn(expectUsersList);
		List<Users> actralUserList =service.findUserAll();
		assertThat(actralUserList,is(expectUsersList));

	}
	@Test
	public void test_findUserById() {
		Users users=new Users();
		users.setId(1);
		doReturn(users).when(usersMapper).selectUserById(1);
		Users ac=service.findUserById(1);
		assertThat(ac, is(users));
	}
	@Test
	public void test_editUser() {
		Users users=new Users();
		users.setId(2);
		users.setAge(29);
		users.setName("lisi");
		service.editUser(users);

	}


}
