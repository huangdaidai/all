package com.hdd.account.controller;

import com.hdd.account.service.ComsumeService;
import com.hdd.account.model.Comsume;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
* author: hdd
* createdOn: 2018-4-15
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
	@RequestMapping(value = "/list")
	@ResponseBody
	public Object list(HttpServletRequest request, HttpServletResponse response, Comsume comsume) {
		List<Comsume> comsumeList = null;
		try {
			 return comsumeService.select(comsume);
		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
		}
		return comsumeList;
	}

	/**
	 * 查询单条记录
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		try {
			String id = request.getParameter("id");
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
