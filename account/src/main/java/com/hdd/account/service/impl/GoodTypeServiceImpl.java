package com.hdd.account.service.impl;

import com.hdd.account.model.GoodType;
import com.hdd.account.dao.GoodTypeDao;
import com.hdd.account.service.GoodTypeService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import java.util.List;


/**
* author: hdd
* createdOn: 2018-4-18
*/
@Service("goodTypeService")
public class GoodTypeServiceImpl implements GoodTypeService{
	
	@Autowired
	GoodTypeDao goodTypeDao;
	
	@Override
	public int insert(GoodType goodType) {
		return goodTypeDao.insert(goodType);
	}

	@Override
	public int deleteOne(String id) {
		return goodTypeDao.deleteOne(id);
	}

	@Override
	public int update(GoodType goodType) {
		return goodTypeDao.update(goodType);

	}

	@Override
	public List<GoodType> select(GoodType goodType) {
		return goodTypeDao.select(goodType);
	}

	@Override
	public PageInfo<GoodType> selectPage(GoodType goodType) {
		return goodTypeDao.selectPage(goodType);
	}

	@Override
	public GoodType selectOne(String id) {
		return goodTypeDao.selectOne(id);
	}
}
