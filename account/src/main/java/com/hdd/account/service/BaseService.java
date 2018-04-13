package com.hdd.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

	public int delete(T entity) {
		return baseDao.delete(entity);
	}

	public int update(T app) {
		return baseDao.update(app);
	}

	public List<T> select(T app) {
		return baseDao.select(app);
	}

	public T selectOne(String id) {
		return baseDao.selectOne(id);
	}

}
