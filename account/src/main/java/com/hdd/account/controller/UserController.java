package com.hdd.account.controller;

import com.hdd.account.service.UserService;
import com.hdd.account.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
* author: hdd
* createdOn: 2018-4-18
*/
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

	Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	/**
	 * 列表视图
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(User user) {
		PageInfo<User> pageInfo=null;
		try {
			pageInfo = userService.selectPage(user);
		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
		}
		return pageInfo;
	}

	/**
	 * 查询单条记录
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView get(@RequestParam(value="userId") String userId) {
		ModelAndView mv = new ModelAndView();
		try {
			if (StringUtils.isNotEmpty(userId)) {
				User data = userService.selectOne(userId);
				mv.addObject("model", data);
			} else {
				mv.addObject("model", new User());
			}

		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
		}

		mv.setViewName("admin/user/get");
		return mv;

	}

	/**
	 * 新增数据
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@RequestBody User user) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = userService.insert(user);
			mv.addObject("success", num);
		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
			mv.addObject("errorMsg", e.getMessage());
		}
		return mv;
	}

	/**
	 * 修改数据
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object edit(@RequestBody User user) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = userService.update(user);
			mv.addObject("success", num);
		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
			mv.addObject("errorMsg", e.getMessage());
		}
		return mv;
	}

	/**
	 * 删除数据
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestParam(value="userId") String userId) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = userService.deleteOne(userId);
			mv.addObject("success", num);
		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
			mv.addObject("errorMsg", e.getMessage());
		}
		return mv;
	}

    
}
