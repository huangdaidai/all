package com.hdd.account.service.impl;

import com.hdd.account.model.Comsume;
import com.hdd.account.dao.ComsumeDao;
import com.hdd.account.service.ComsumeService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.PageInfo;
import java.util.List;


/**
* author: hdd
* createdOn: 2018-4-18
*/
@Service("comsumeService")
public class ComsumeServiceImpl implements ComsumeService{
	
	@Autowired
	ComsumeDao comsumeDao;
	
	@Override
	public int insert(Comsume comsume) {
		return comsumeDao.insert(comsume);
	}

	@Override
	public int deleteOne(String id) {
		return comsumeDao.deleteOne(id);
	}

	@Override
	public int update(Comsume comsume) {
		return comsumeDao.update(comsume);

	}

	@Override
	public List<Comsume> select(Comsume comsume) {
		return comsumeDao.select(comsume);
	}

	@Override
	public PageInfo<Comsume> selectPage(Comsume comsume) {
		return comsumeDao.selectPage(comsume);
	}

	@Override
	public Comsume selectOne(String id) {
		return comsumeDao.selectOne(id);
	}
}
