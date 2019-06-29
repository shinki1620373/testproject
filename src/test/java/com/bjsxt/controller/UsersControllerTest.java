package com.bjsxt.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bjsxt.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UsersControllerTest {

	private MockMvc mockMvc;

	  @Autowired
	  UsersController target;

	  @Before
	  public void setup() {
	    mockMvc = MockMvcBuilders.standaloneSetup(target).build();
	  }

	@Test
	public void testAddUser() throws Exception {


		Users users =new Users();
		users.setId(1);
		  // when
	    mockMvc.perform(post("/users/addUser").flashAttr("users", users))
	        .andExpect(status().isOk())
	        .andExpect(view().name("ok"));
	}
	@Test
	public void testUpdateUser() throws Exception {


		Users users =new Users();
		users.setId(2);
		  // when
	    mockMvc.perform(post("/users/editUser").flashAttr("users", users))
	        .andExpect(status().isOk())
	        .andExpect(view().name("forward:/users/findUserAll"));
	}
	@Test
	public void testFindUserAll() throws Exception {

	    mockMvc.perform(get("/users/findUserAll"))
	        .andExpect(status().isOk())
	        .andExpect(view().name("showUsers"));
	    System.out.println("dddddddddd");
	}

}
