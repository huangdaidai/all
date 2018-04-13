package com.hdd.account.service;

import com.hdd.account.model.GoodType;
import com.hdd.account.dao.GoodTypeDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
/**
* author: hdd
* createdOn: 2018-4-13
*/
@Service("goodTypeService")
public class GoodTypeService extends BaseService<GoodTypeDao, GoodType>  {

    @Resource(name = "goodTypeDao")  
    private GoodTypeDao dao;  
      
    @Resource(name = "goodTypeDao") 
    public void setDao(GoodTypeDao dao) {  
        super.setDao(dao);  
    }  
}
