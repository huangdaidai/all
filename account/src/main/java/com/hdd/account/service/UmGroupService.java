package com.hdd.account.service;

import com.hdd.account.model.UmGroup;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
* author: hdd
* createdOn: 2018-4-18
*/
public interface UmGroupService {
	/**
	 * 插入记录
	 * 
	 * @param t
	 * @return
	 */
	public int insert(UmGroup umGroup);

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
	public int update(UmGroup umGroup);

	/**
	 * 查询列表
	 * 
	 * @param t
	 * @return
	 */
	public List<UmGroup> select(UmGroup umGroup);

	/**
	 * 查询列表--分页
	 * 
	 * @param t
	 * @return
	 */
	public PageInfo<UmGroup> selectPage(UmGroup umGroup);

	/**
	 * 查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public UmGroup selectOne(String id);
}
