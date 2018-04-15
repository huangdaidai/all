package com.hdd.account.service;

import com.hdd.account.model.GoodDetail;
import com.hdd.account.dao.GoodDetailDao;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
/**
* author: hdd
* createdOn: 2018-4-15
*/
@Service("goodDetailService")
public class GoodDetailService extends BaseService<GoodDetailDao, GoodDetail>  {

    @Resource(name = "goodDetailDao")  
    private GoodDetailDao dao;  
      
    @Resource(name = "goodDetailDao") 
    public void setDao(GoodDetailDao dao) {  
        super.setDao(dao);  
    }  
}
