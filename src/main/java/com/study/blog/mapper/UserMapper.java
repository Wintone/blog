package com.study.blog.mapper;

import com.study.blog.data.Sequence;
import com.study.blog.data.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

	public User insert(User user);

	public User getById(Long userId);


	public void update(User user);

	public void deleteById(Long userId);
}
