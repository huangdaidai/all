package com.hdd.account.service;

import com.hdd.account.model.Comsume;
import com.hdd.account.dao.ComsumeDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
/**
* author: hdd
* createdOn: 2018-4-15
*/
@Service("comsumeService")
public class ComsumeService extends BaseService<ComsumeDao, Comsume>  {

    @Resource(name = "comsumeDao")  
    private ComsumeDao dao;  
      
    @Resource(name = "comsumeDao") 
    public void setDao(ComsumeDao dao) {  
        super.setDao(dao);  
    }  
}
