package com.study.blog.controller;

import com.study.blog.data.Result;
import com.study.blog.data.User;
import com.study.blog.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

	private Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/user/{userId}")
	public Result userGet(@PathVariable Long userId) {
		User user = userService.getById(userId);
		log.debug("The method is ending");
		return Result.success(user);
	}


	/**
	 * 新建用户信息
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/users/user")
	public Result insertUser(@RequestBody User user) {
		userService.insertUser(user);
		log.debug("The method is ending");
		return Result.success();
	}

	@GetMapping("/userCheck")
	public Result userCheck(@RequestParam String loginName) {
		boolean exist = userService.checkUser(loginName);
		return Result.success(exist);
	}
}
