package com.hdd.account.controller;

import com.hdd.account.service.ComsumeService;
import com.hdd.account.model.Comsume;

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
@RequestMapping("/comsume")
public class ComsumeController extends BaseController {

	Logger log=LoggerFactory.getLogger(ComsumeController.class);
	
	@Autowired
	ComsumeService comsumeService;

	/**
	 * 列表视图
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(Comsume comsume) {
		PageInfo<Comsume> pageInfo=null;
		try {
			System.out.println("333333333333333:"+request.getParameter("a"));
			pageInfo = comsumeService.selectPage(comsume);
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
	public ModelAndView get(@RequestParam(value="id") String id) {
		ModelAndView mv = new ModelAndView();
		try {
			if (StringUtils.isNotEmpty(id)) {
				Comsume data = comsumeService.selectOne(id);
				mv.addObject("model", data);
			} else {
				mv.addObject("model", new Comsume());
			}

		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
		}

		mv.setViewName("admin/comsume/get");
		return mv;

	}

	/**
	 * 新增数据
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@RequestBody Comsume comsume) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = comsumeService.insert(comsume);
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
	public Object edit(@RequestBody Comsume comsume) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = comsumeService.update(comsume);
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
	public Object delete(@RequestParam(value="id") String id) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = comsumeService.deleteOne(id);
			mv.addObject("success", num);
		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
			mv.addObject("errorMsg", e.getMessage());
		}
		return mv;
	}

    
}
