package com.bjsxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bjsxt.pojo.Users;
import com.bjsxt.service.UsersService;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private UsersService usersService;


	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page) {
		return page;
	}


	@RequestMapping(path = "/addUser", method = RequestMethod.POST)
	public String addUser(Users users) {
	    this.usersService.addUser(users);
		return "ok";
	}


	@RequestMapping(path = "/findUserAll", method = RequestMethod.GET)
	public String findUserAll(Model model) {
		List<Users> list = this.usersService.findUserAll();
		model.addAttribute("list",list);
		return "showUsers";
	}
	@RequestMapping("/findUserById")
	public String findUserById(Integer id,Model model) {
		Users user=this.usersService.findUserById(id);


		model.addAttribute("user", user);
		return"updateUser";
	}

	@RequestMapping(path = "/editUser", method = RequestMethod.POST)
	public String updateUser(Users users) {
		usersService.editUser(users);
		return "forward:/users/findUserAll";
	}




}
