package com.hdd.account.service;

import com.hdd.account.model.User;
import com.github.pagehelper.PageInfo;
import java.util.List;
/**
* author: hdd
* createdOn: 2018-4-18
*/
public interface UserService {
	/**
	 * 插入记录
	 * 
	 * @param t
	 * @return
	 */
	public int insert(User user);

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
	public int update(User user);

	/**
	 * 查询列表
	 * 
	 * @param t
	 * @return
	 */
	public List<User> select(User user);

	/**
	 * 查询列表--分页
	 * 
	 * @param t
	 * @return
	 */
	public PageInfo<User> selectPage(User user);

	/**
	 * 查询单条记录
	 * 
	 * @param id
	 * @return
	 */
	public User selectOne(String id);
}
