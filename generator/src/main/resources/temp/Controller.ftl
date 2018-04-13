package ${package}.controller;

import ${package}.service.${tableClass.className}Service;
import ${package}.model.${tableClass.className};
import ${package}.common.PageBean;
import ${package}.common.PaginationContext;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
* author: ${author}
* createdOn: ${now?date}
*/
@Controller
@RequestMapping("/${tableClass.className?lower_case}")
public class ${tableClass.className}Controller extends BaseController {

    @Autowired
    ${tableClass.className}Service ${tableClass.className?uncap_first}Service;
	
	/**
	 * 列表视图
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, ${tableClass.className} ${tableClass.className?uncap_first}) {
		PageBean<${tableClass.className}> pagebean = null;
		try {

			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			List<${tableClass.className}> data = ${tableClass.className?uncap_first}Service.select(${tableClass.className?uncap_first});
			pagebean = new PageBean<${tableClass.className}>(data);
		} catch (Exception e) {
			Log("失败", e);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/${tableClass.className?uncap_first}/list");
		mv.addObject("page", pagebean);
		return mv;
	}

	/**
	 * 新增或编辑表单视图
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView Form(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		try {
			${primaryKeyField.type} ID = request.getParameter("ID");
			
			if (StringUtils.isNotEmpty(ID)) {
				${tableClass.className} data = ${tableClass.className?uncap_first}Service.selectOne(ID);
				mv.addObject("model", data);
			} else {
				mv.addObject("model", new ${tableClass.className}());
			}

		} catch (Exception e) {
			Log("失败", e);
		}

		mv.setViewName("admin/${tableClass.className?uncap_first}/form");
		return mv;

	}

	/**
	 * 保存数据(不存在则新增，存在则更新)
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(${tableClass.className} ${tableClass.className?uncap_first}) {
		try {
			if (${tableClass.className?uncap_first} != null) {
				${tableClass.className?uncap_first}Service.save(${tableClass.className?uncap_first});
			}

		} catch (Exception e) {
			Log("失败", e);
		}

		ModelAndView mv = new ModelAndView("redirect:/${tableClass.className?uncap_first}/list");
		return mv;
	}
	
	/**
	 * 查询数据列表
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Object getList(${tableClass.className} ${tableClass.className?uncap_first}) {

		try {
			PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
			List<${tableClass.className}> data = ${tableClass.className?uncap_first}Service.select(${tableClass.className?uncap_first});
			PageBean<${tableClass.className}> pagebean = new PageBean<${tableClass.className}>(data);

			return SuccessResponse("成功", pagebean.getList(), pagebean.getTotal());
		} catch (Exception e) {

			return FailResponse("失败", null, e);

		}

	}
	
	/**
	 * 查询一条数据
	 */
	@RequestMapping(value = "/{ID}", method = RequestMethod.GET)
	@ResponseBody
	public Object get(@PathVariable("ID") ${primaryKeyField.type} ID) {

		try {
			${tableClass.className} data = ${tableClass.className?uncap_first}Service.selectOne(ID);

			return SuccessResponse("成功", data, 1);
		} catch (Exception e) {

			return FailResponse("失败", null, e);

		}
	}
	
	/**
	 * 新增数据
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@RequestBody ${tableClass.className} ${tableClass.className?uncap_first}) {
		try {
			int data = ${tableClass.className?uncap_first}Service.insert(${tableClass.className?uncap_first});

			return SuccessResponse("成功", data, 1);
		} catch (Exception e) {

			return FailResponse("失败", null, e);
		}
	}

	/**
	 * 修改数据
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public Object edit(@RequestBody ${tableClass.className} ${tableClass.className?uncap_first}) {
		try {
			int data = ${tableClass.className?uncap_first}Service.update(${tableClass.className?uncap_first});

			return SuccessResponse("成功", data, 1);
		} catch (Exception e) {

			return FailResponse("失败", null, e);
		}
	}

	/**
	 * 删除数据
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	@ResponseBody
	public Object delete(@RequestParam(value="ID") ${primaryKeyField.type} ID) {
		try {
			int data = ${tableClass.className?uncap_first}Service.deleteOne(ID);

			return SuccessResponse("成功", data, 1);
		} catch (Exception e) {

			return FailResponse("失败", null, e);

		}
	}

    
}
