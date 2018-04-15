package com.hdd.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.hdd.account.dao.BaseDao;
import com.hdd.account.model.BaseEntity;

/**
 * Service基类
 */

@Service("baseService")
public abstract class BaseService<D extends BaseDao<T>, T extends BaseEntity<T>> {

	/**
	 * 持久层对象
	 */

	protected D baseDao;

	public void setDao(D baseDao) {
		this.baseDao = baseDao;
	}
	public int insert(T entity) {
		return baseDao.insert(entity);
	}

	public int deleteOne(String id) {
		return baseDao.deleteOne(id);
	}

	public int update(T t) {
		return baseDao.update(t);
	}

	public List<T> select(T t) {
		return baseDao.select(t);
	}
	
	public PageInfo<T> selectPage(T t) {
		return baseDao.selectPage(t);
	}

	public T selectOne(String id) {
		return baseDao.selectOne(id);
	}

}
