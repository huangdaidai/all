package com.hdd.account.service;

import com.hdd.account.model.User;
import com.hdd.account.dao.UserDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
/**
* author: hdd
* createdOn: 2018-4-15
*/
@Service("userService")
public class UserService extends BaseService<UserDao, User>  {

    @Resource(name = "userDao")  
    private UserDao dao;  
      
    @Resource(name = "userDao") 
    public void setDao(UserDao dao) {  
        super.setDao(dao);  
    }  
}
