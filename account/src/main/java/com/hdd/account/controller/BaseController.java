package com.hdd.account.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.hdd.account.service.ComsumeService;

/**
* author: hdd
* createdOn: 2018-4-17
*/
public class BaseController {
	@Autowired
	ComsumeService comsumeService;
	
    
}
