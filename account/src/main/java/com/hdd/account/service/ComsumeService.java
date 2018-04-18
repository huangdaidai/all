package com.hdd.account.service;

import com.hdd.account.model.Comsume;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
* author: hdd
* createdOn: 2018-4-18
*/
public interface ComsumeService {
	/**
	 * 插入记录
	 * 
	 * @param t
	 * @return
	 */
	public int insert(Comsume comsume);

	/**
	 * 删除记录
	 * 
	 * @param t
	 * @return
	 */
	public int deleteOne(String id);
	/**
	 * 更新记录
	 * 
	 * @param t
	 * @return
	 */
	public int update(Comsume comsume);

	/**
	 * 查询列表
	 * 
	 * @param t
	 * @return
	 */
	public List<Comsume> select(Comsume comsume);

	/**
	 * 查询列表--分页
	 * 
	 * @param t
	 * @return
	 */
	public PageInfo<Comsume> selectPage(Comsume comsume);

	/**
	 * 查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public Comsume selectOne(String id);
}
