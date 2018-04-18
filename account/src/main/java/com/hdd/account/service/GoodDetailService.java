package com.hdd.account.service;

import com.hdd.account.model.GoodDetail;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
* author: hdd
* createdOn: 2018-4-18
*/
public interface GoodDetailService {
	/**
	 * 插入记录
	 * 
	 * @param t
	 * @return
	 */
	public int insert(GoodDetail goodDetail);

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
	public int update(GoodDetail goodDetail);

	/**
	 * 查询列表
	 * 
	 * @param t
	 * @return
	 */
	public List<GoodDetail> select(GoodDetail goodDetail);

	/**
	 * 查询列表--分页
	 * 
	 * @param t
	 * @return
	 */
	public PageInfo<GoodDetail> selectPage(GoodDetail goodDetail);

	/**
	 * 查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public GoodDetail selectOne(String id);
}
