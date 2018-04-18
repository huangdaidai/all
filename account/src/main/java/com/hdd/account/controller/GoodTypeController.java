package com.hdd.account.controller;

import com.hdd.account.service.GoodTypeService;
import com.hdd.account.model.GoodType;

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
@RequestMapping("/goodType")
public class GoodTypeController extends BaseController {

	Logger log=LoggerFactory.getLogger(GoodTypeController.class);
	
	@Autowired
	GoodTypeService goodTypeService;

	/**
	 * 列表视图
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(GoodType goodType) {
		PageInfo<GoodType> pageInfo=null;
		try {
			pageInfo = goodTypeService.selectPage(goodType);
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
	public ModelAndView get(@RequestParam(value="goodTypeCode") String goodTypeCode) {
		ModelAndView mv = new ModelAndView();
		try {
			if (StringUtils.isNotEmpty(goodTypeCode)) {
				GoodType data = goodTypeService.selectOne(goodTypeCode);
				mv.addObject("model", data);
			} else {
				mv.addObject("model", new GoodType());
			}

		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
		}

		mv.setViewName("admin/goodType/get");
		return mv;

	}

	/**
	 * 新增数据
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@RequestBody GoodType goodType) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = goodTypeService.insert(goodType);
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
	public Object edit(@RequestBody GoodType goodType) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = goodTypeService.update(goodType);
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
	public Object delete(@RequestParam(value="goodTypeCode") String goodTypeCode) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = goodTypeService.deleteOne(goodTypeCode);
			mv.addObject("success", num);
		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
			mv.addObject("errorMsg", e.getMessage());
		}
		return mv;
	}

    
}
