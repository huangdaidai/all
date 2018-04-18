package com.hdd.account.service.impl;

import com.hdd.account.model.GoodDetail;
import com.hdd.account.dao.GoodDetailDao;
import com.hdd.account.service.GoodDetailService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import java.util.List;


/**
* author: hdd
* createdOn: 2018-4-18
*/
@Service("goodDetailService")
public class GoodDetailServiceImpl implements GoodDetailService{
	
	@Autowired
	GoodDetailDao goodDetailDao;
	
	@Override
	public int insert(GoodDetail goodDetail) {
		return goodDetailDao.insert(goodDetail);
	}

	@Override
	public int deleteOne(String id) {
		return goodDetailDao.deleteOne(id);
	}

	@Override
	public int update(GoodDetail goodDetail) {
		return goodDetailDao.update(goodDetail);

	}

	@Override
	public List<GoodDetail> select(GoodDetail goodDetail) {
		return goodDetailDao.select(goodDetail);
	}

	@Override
	public PageInfo<GoodDetail> selectPage(GoodDetail goodDetail) {
		return goodDetailDao.selectPage(goodDetail);
	}

	@Override
	public GoodDetail selectOne(String id) {
		return goodDetailDao.selectOne(id);
	}
}
