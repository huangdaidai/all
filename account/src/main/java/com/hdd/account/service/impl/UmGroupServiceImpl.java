package com.hdd.account.service.impl;

import com.hdd.account.model.UmGroup;
import com.hdd.account.dao.UmGroupDao;
import com.hdd.account.service.UmGroupService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import java.util.List;


/**
* author: hdd
* createdOn: 2018-4-18
*/
@Service("umGroupService")
public class UmGroupServiceImpl implements UmGroupService{
	
	@Autowired
	UmGroupDao umGroupDao;
	
	@Override
	public int insert(UmGroup umGroup) {
		return umGroupDao.insert(umGroup);
	}

	@Override
	public int deleteOne(String id) {
		return umGroupDao.deleteOne(id);
	}

	@Override
	public int update(UmGroup umGroup) {
		return umGroupDao.update(umGroup);

	}

	@Override
	public List<UmGroup> select(UmGroup umGroup) {
		return umGroupDao.select(umGroup);
	}

	@Override
	public PageInfo<UmGroup> selectPage(UmGroup umGroup) {
		return umGroupDao.selectPage(umGroup);
	}

	@Override
	public UmGroup selectOne(String id) {
		return umGroupDao.selectOne(id);
	}
}
