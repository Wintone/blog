package com.study.blog.service;

import com.study.blog.data.User;
import com.study.blog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 通过用户id得到用户信息
	 * @param userId
	 * @return
	 */
	public User getById(Long userId) {
		User user = this.userMapper.getById(userId);
		return user;
	}

	/**
	 * 新建用户信息
	 * @param user
	 */
	public User insertUser(User user) {
		this.userMapper.insert(user);
		return user;
	}

	/**
	 * 更新用户信息
	 * @param user
	 */
	public void update(User user) {
	}

	/**
	 * 删除用户信息
	 * @param userId
	 */
	public void deleteById(Long userId) {
	}
}
