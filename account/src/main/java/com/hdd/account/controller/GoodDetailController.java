package com.hdd.account.controller;

import com.hdd.account.service.GoodDetailService;
import com.hdd.account.model.GoodDetail;

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
@RequestMapping("/goodDetail")
public class GoodDetailController extends BaseController {

	Logger log=LoggerFactory.getLogger(GoodDetailController.class);
	
	@Autowired
	GoodDetailService goodDetailService;

	/**
	 * 列表视图
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public Object list(GoodDetail goodDetail) {
		PageInfo<GoodDetail> pageInfo=null;
		try {
			pageInfo = goodDetailService.selectPage(goodDetail);
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
	public ModelAndView get(@RequestParam(value="goodCode") String goodCode) {
		ModelAndView mv = new ModelAndView();
		try {
			if (StringUtils.isNotEmpty(goodCode)) {
				GoodDetail data = goodDetailService.selectOne(goodCode);
				mv.addObject("model", data);
			} else {
				mv.addObject("model", new GoodDetail());
			}

		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
		}

		mv.setViewName("admin/goodDetail/get");
		return mv;

	}

	/**
	 * 新增数据
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@RequestBody GoodDetail goodDetail) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = goodDetailService.insert(goodDetail);
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
	public Object edit(@RequestBody GoodDetail goodDetail) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = goodDetailService.update(goodDetail);
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
	public Object delete(@RequestParam(value="goodCode") String goodCode) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = goodDetailService.deleteOne(goodCode);
			mv.addObject("success", num);
		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
			mv.addObject("errorMsg", e.getMessage());
		}
		return mv;
	}

    
}
