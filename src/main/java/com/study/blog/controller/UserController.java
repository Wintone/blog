package com.study.blog.controller;

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

	@GetMapping("/user/{loginName}")
	public Result userGet(@PathVariable String loginName) {
		UserEntity userEntity = userService.getUserEntityByLoginName(loginName);
		log.debug("The method is ending");
		return Result.success(userEntity);
	}


	/**
	 * 新建用户信息
	 * 
	 * @param userEntity
	 * @return
	 */
	@PostMapping("/users/user")
	public Result insertUser(@RequestBody UserEntity userEntity) {
		userService.insertUser(userEntity);
		log.debug("The method is ending");
		return Result.success();
	}

	@PostMapping("/userCheck")
	public Result userCheck(@RequestBody UserEntity userEntity) {
		UserEntity userEntity1 = userService.checkUser(userEntity.getLoginName(), userEntity.getPassword());
		return Result.success(userEntity1);
	}
}
