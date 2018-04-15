package com.hdd.account.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author huangshunsi
 * 2018年4月12日
 */

@Data
public class BaseEntity<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public int pageNum;
	
	public int pageSize;

}
