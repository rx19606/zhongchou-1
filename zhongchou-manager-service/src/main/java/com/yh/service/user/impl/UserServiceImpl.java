package com.yh.service.user.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.mapper.UserMapper;
import com.yh.pojo.User;
import com.yh.pojo.UserExample;
import com.yh.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	/**
	 * 添加用户
	 */

	@Autowired
	private UserMapper usermapper;
	

	@Override
	public Integer InsterUser(User user) {
	    int insert = usermapper.insert(user);
		return insert;
	}

	/**
	 * 获取用户列表信息
	 */
	@Override
	public List<User> getUser() {
		// 执行查询
		UserExample example = new UserExample();
		List<User> selectByExample = usermapper.selectByExample(example);
		
		return selectByExample;
	}

	/**
	 * 删除用户信息
	 */
	@Override
	public Integer delectuser(Integer usId) {
		
		int deleteByExample = usermapper.deleteByPrimaryKey(usId);
		return deleteByExample;
	}

	/**
	 * 
	 * 查看用户信息
	 */
	@Override
	public User selectuser(Integer usId) {
		
		 User selectByPrimaryKey = usermapper.selectByPrimaryKey(usId);
		 
		
		return selectByPrimaryKey;
	}

	/*
	 * 修改用户信息
	 */
	@Override
	public Integer updatauser(User user) {
		int updateByPrimaryKeySelective = usermapper.updateByPrimaryKey(user);
	/*	UserExample example = new UserExample();
		Criteria createCriteria = example.createCriteria();
		createCriteria.andUsIdcardEqualTo(usId+"");
		int updateByExample = usermapper.updateByExample(user,example);*/
		return updateByPrimaryKeySelective;
	}

}
