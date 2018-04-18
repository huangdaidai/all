package com.hdd.account.service.impl;

import com.hdd.account.model.User;
import com.hdd.account.dao.UserDao;
import com.hdd.account.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import java.util.List;


/**
* author: hdd
* createdOn: 2018-4-18
*/
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

	@Override
	public int deleteOne(String id) {
		return userDao.deleteOne(id);
	}

	@Override
	public int update(User user) {
		return userDao.update(user);

	}

	@Override
	public List<User> select(User user) {
		return userDao.select(user);
	}

	@Override
	public PageInfo<User> selectPage(User user) {
		return userDao.selectPage(user);
	}

	@Override
	public User selectOne(String id) {
		return userDao.selectOne(id);
	}
}
