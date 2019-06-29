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
import com.bjsxt.service.impl.MemberServiceImpl;
@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {
	@InjectMocks
	MemberServiceImpl service;
	@Mock
	UsersMapper usersMapper;


	@Test
	public void test_getUser() {
		List<Users> expectUsersList= new ArrayList();
		Users users = new Users();
		users.setId(1);
		users.setName("zhangsan");
		expectUsersList.add(users);
		doReturn(expectUsersList).when(usersMapper).selectUserByIdName(1, "zhangsan");

		List<Users> acList=service.getUser(users);
		assertThat(acList,is(expectUsersList));

	}
	@Test
	public void test_getUser3() {
		List<Users> expectUsersList= new ArrayList();
		Users users = new Users();
		users.setId(1);
		users.setName(null);
		expectUsersList.add(users);
		doReturn(expectUsersList).when(usersMapper).selectUserByIdName(1,null);
		List<Users> acList=service.getUser(users);
		assertThat(acList,is(expectUsersList));
	}
	@Test
	public void test_getUser2() {
		List<Users> expectUsersList= new ArrayList();
		Users users = new Users();
		users.setId(2);
		users.setName("lisi");
		expectUsersList.add(users);
		doReturn(expectUsersList).when(usersMapper).selectUserByIdName(2, "lisi");

		List<Users> acList=service.getUser(users);
		assertThat(acList,is(expectUsersList));
		System.out.println("gugugugugg");

	}
	@Test
	public void test_findUserAll() {
		List<Users> expectUsersList= new ArrayList();
		Users users =new Users();
		users.setId(1);
		users.setName("zhangsan");
		expectUsersList.add(users);
		doReturn(expectUsersList).when(usersMapper).selectUsersAll();
		List<Users> acList=service.findUserAll();
		assertThat(acList,is(expectUsersList));
	}
	@Test
	public void test_findUserById() {
		Users users =new Users();
		users.setId(1);
		doReturn(users).when(usersMapper).selectUserById(1);
		Users ac=service.findUserById(1);
		assertThat(ac, is(users));
		System.out.println("uuuuuuuuuuu");
	}
	@Test
	public void test_editUser() {
		Users users = new Users();
		users.setName("zhang");
		users.setId(1);
		users.setAge(28);
		service.editUser(users);
		System.out.println("ok");
	}

}
