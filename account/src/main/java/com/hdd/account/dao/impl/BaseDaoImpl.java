package com.hdd.account.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hdd.account.dao.BaseDao;
import com.hdd.account.model.BaseEntity;

public class BaseDaoImpl<T extends BaseEntity> implements BaseDao<T>{
	@Resource
	private SqlSessionFactory sessionFactory;

	protected SqlSession getSession() {
		return sessionFactory.openSession();
	}

	/**
	 * 命名空间
	 */
	protected String NAMESPACE;

	/**
	 * 根据获取子类全系列名作为mapper的namespace，namespace约定为mapper类全系列名
	 */
	public BaseDaoImpl() {
		NAMESPACE = this.getClass().getName() + ".";
	}

	/**
	 * 插入记录
	 * 
	 * @param t
	 * @return
	 */
	@Override
	public int insert(T t) {
		return getSession().insert(NAMESPACE + "insert", t);
	}

	/**
	 * 删除记录
	 * 
	 * @param t
	 * @return
	 */
	@Override
	public int deleteOne(String id) {
		return getSession().delete(NAMESPACE + "deleteOne", id);
	}

	/**
	 * 更新记录
	 * 
	 * @param t
	 * @return
	 */
	@Override
	public int update(T t) {
		return getSession().update(NAMESPACE + "update", t);

	}

	/**
	 * 查询列表
	 * 
	 * @param t
	 * @return
	 */
	@Override
	public List<T> select(T t) {
		return getSession().selectList(NAMESPACE + "select", t);
	}

	/**
	 * 查询列表--分页
	 * 
	 * @param t
	 * @return
	 */
	@Override
	public PageInfo<T> selectPage(T t) {
		PageHelper.startPage(t.getPageNum(), t.getPageSize());
		List<T> list = getSession().selectList(NAMESPACE + "select", t);
		return new PageInfo<>(list);
	}

	/**
	 * 查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public T selectOne(String id) {
		return getSession().selectOne(NAMESPACE + "selectOne", id);
	}
}
