package com.hdd.account.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.hdd.account.model.BaseEntity;

/**
 * 
 * @author huangshunsi
 * 2018年4月17日
 * @param <T>
 */
public interface BaseService<T extends BaseEntity> {

	/**
	 * 插入记录
	 * @param t
	 * @return
	 */
	public int insert(T t);
	
	/**
	 * 删除记录
	 * @param t
	 * @return
	 */
	public int deleteOne(String id);
	/**
	 * 更新记录
	 * @param t
	 * @return
	 */
	public int update(T t);

	/**
	 * 查询列表
	 * @param t
	 * @return
	 */
	public List<T> select(T t);
	
	/**
	 * 查询列表--分页
	 * @param t
	 * @return
	 */
	public PageInfo<T> selectPage(T t);

	/**
	 * 查询单条记录
	 * @param id
	 * @return
	 */
	public T selectOne(String id);
}
