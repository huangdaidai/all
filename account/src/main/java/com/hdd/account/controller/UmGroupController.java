package com.hdd.account.controller;

import com.hdd.account.service.UmGroupService;
import com.hdd.account.model.UmGroup;

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
@RequestMapping("/umGroup")
public class UmGroupController extends BaseController {

	Logger log=LoggerFactory.getLogger(UmGroupController.class);
	
	@Autowired
	UmGroupService umGroupService;

	/**
	 * 列表视图
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(UmGroup umGroup) {
		PageInfo<UmGroup> pageInfo=null;
		try {
			pageInfo = umGroupService.selectPage(umGroup);
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
	public ModelAndView get(@RequestParam(value="groupCode") String groupCode) {
		ModelAndView mv = new ModelAndView();
		try {
			if (StringUtils.isNotEmpty(groupCode)) {
				UmGroup data = umGroupService.selectOne(groupCode);
				mv.addObject("model", data);
			} else {
				mv.addObject("model", new UmGroup());
			}

		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
		}

		mv.setViewName("admin/umGroup/get");
		return mv;

	}

	/**
	 * 新增数据
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@RequestBody UmGroup umGroup) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = umGroupService.insert(umGroup);
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
	public Object edit(@RequestBody UmGroup umGroup) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = umGroupService.update(umGroup);
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
	public Object delete(@RequestParam(value="groupCode") String groupCode) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = umGroupService.deleteOne(groupCode);
			mv.addObject("success", num);
		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
			mv.addObject("errorMsg", e.getMessage());
		}
		return mv;
	}

    
}
