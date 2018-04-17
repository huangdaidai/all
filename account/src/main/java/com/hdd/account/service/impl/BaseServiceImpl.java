package com.hdd.account.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.hdd.account.dao.BaseDao;
import com.hdd.account.dao.ComsumeDao;
import com.hdd.account.model.BaseEntity;
import com.hdd.account.model.Comsume;
import com.hdd.account.service.BaseService;

/**
 * Service基类
 */

@Service
public class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
	
	BaseDao<T> baseDao;
	
	ComsumeDao comsumeDao;
	
	@Override
	public int insert(T entity) {
		return baseDao.insert(entity);
	}

	@Override
	public int deleteOne(String id) {
		return baseDao.deleteOne(id);
	}

	@Override
	public int update(T t) {
		return baseDao.update(t);
	}

	@Override
	public List<T> select(T t) {
		return baseDao.select(t);
	}
	
	@Override
	public PageInfo<T> selectPage(T t) {
		return baseDao.selectPage(t);
	}

	@Override
	public T selectOne(String id) {
		return (T) baseDao.selectOne(id);
	}

}
