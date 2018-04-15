package com.hdd.account.service;

import com.hdd.account.model.UmGroup;
import com.hdd.account.dao.UmGroupDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
/**
* author: hdd
* createdOn: 2018-4-15
*/
@Service("umGroupService")
public class UmGroupService extends BaseService<UmGroupDao, UmGroup>  {

    @Resource(name = "umGroupDao")  
    private UmGroupDao dao;  
      
    @Resource(name = "umGroupDao") 
    public void setDao(UmGroupDao dao) {  
        super.setDao(dao);  
    }  
}
