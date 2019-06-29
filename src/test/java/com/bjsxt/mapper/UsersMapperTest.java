package com.bjsxt.mapper;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bjsxt.pojo.Users;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DbUnitTestExecutionListener.class
})
public class UsersMapperTest {

	@Autowired
	UsersMapper mapper;

	@Test
    @DatabaseSetup("/UsersMapper/selectUsersAll_nomal.xml")
	public void test_selectUsersAll(){
		List<Users> actual=mapper.selectUsersAll();
		Users users=new Users();
		users.setId(4);
		users.setName("lisi");
		users.setAge(25);
		assertThat(actual.get(0).getId(),is(users.getId()));
		assertThat(actual.get(0).getName(),is(users.getName()));
		assertThat(actual.get(0).getAge(),is(users.getAge()));

		Users users1=new Users();
		users1.setId(5);
		users1.setName("wangwu");
		users1.setAge(77);
		assertThat(actual.get(1).getId(),is(users1.getId()));
		assertThat(actual.get(1).getName(),is(users1.getName()));
		assertThat(actual.get(1).getAge(),is(users1.getAge()));

	}
    /**
     * 正常件テスト
     */
	@Test
    @DatabaseSetup("/UsersMapper/selectUsersAll_recordzero.xml")
	public void test_selectUsersAll_zero(){
		List<Users> actual=mapper.selectUsersAll();

		assertThat(actual,is(new ArrayList()));

	}

	@Test
	@DatabaseSetup("/UsersMapper/editUser_nomal.xml")
	@ExpectedDatabase(
	    value="/UsersMapper/editUser_nomal_expect.xml",
	    assertionMode=DatabaseAssertionMode.NON_STRICT
	)
	public void test_editUser() {
		Users users=new Users();
		users.setId(4);
		users.setName("zhangsan");
		users.setAge(99);
		mapper.editUser(users);

	}

	/**
	 * ゼロ件更新テスト
	 */
	@Test
	@DatabaseSetup("/UsersMapper/editUser_zero.xml")
	@ExpectedDatabase(
	    value="/UsersMapper/editUser_zero_expect.xml",
	    assertionMode=DatabaseAssertionMode.NON_STRICT
	)
	public void test_editUser_zero() {
		Users users=new Users();
		users.setId(6);
		users.setName("zhangsan");
		users.setAge(99);
		mapper.editUser(users);

	}

	@Test
	@DatabaseSetup("/UsersMapper/insertUser_nomal.xml")
	@ExpectedDatabase(
	    value="/UsersMapper/insertUser_nomal_expect.xml",
	    assertionMode=DatabaseAssertionMode.NON_STRICT
	)
	public void test_insertUser() {
		Users users=new Users();
		users.setId(6);
		users.setName("lisi");
		users.setAge(88);
		mapper.insertUser(users);

	}

	@Test
    @DatabaseSetup("/UsersMapper/selectUserById_nomal.xml")
	public void test_selectUserById(){
		Users actual=mapper.selectUserById(4);
		Users users=new Users();
		users.setId(4);
		users.setName("lisi");
		users.setAge(25);
		assertThat(actual.getId(),is(users.getId()));
		assertThat(actual.getName(),is(users.getName()));
		assertThat(actual.getAge(),is(users.getAge()));



	}
	@Test
    @DatabaseSetup("/UsersMapper/selectUserById_recordzero.xml")
	public void test_selectUserById_zero(){
		Users actual=mapper.selectUserById(30);
		Users expect=null;
		assertThat(actual, is(expect));




	}



}
