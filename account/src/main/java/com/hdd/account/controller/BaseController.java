package com.hdd.account.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

/**
* author: hdd
* createdOn: 2018-4-18
*/
public class BaseController {
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpSession session;
    
	Object success(Object o){
		return o;
	}
}
