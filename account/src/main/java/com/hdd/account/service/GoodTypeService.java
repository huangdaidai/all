package com.hdd.account.service;

import com.hdd.account.model.GoodType;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
* author: hdd
* createdOn: 2018-4-18
*/
public interface GoodTypeService {
	/**
	 * 插入记录
	 * 
	 * @param t
	 * @return
	 */
	public int insert(GoodType goodType);

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
	public int update(GoodType goodType);

	/**
	 * 查询列表
	 * 
	 * @param t
	 * @return
	 */
	public List<GoodType> select(GoodType goodType);

	/**
	 * 查询列表--分页
	 * 
	 * @param t
	 * @return
	 */
	public PageInfo<GoodType> selectPage(GoodType goodType);

	/**
	 * 查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public GoodType selectOne(String id);
}
