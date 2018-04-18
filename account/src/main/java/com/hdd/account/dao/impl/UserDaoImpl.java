package com.hdd.account.dao.impl;

import com.hdd.account.model.User;
import com.hdd.account.dao.UserDao;
import org.springframework.stereotype.Repository;
/**
* author: hdd
* 2018-4-18
*/
@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User>
	implements UserDao{
   
}