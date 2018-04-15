package ${package}.controller;

import ${package}.service.${table.className}Service;
import ${package}.model.${table.className};

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
* author: ${author}
* createdOn: ${now?date}
*/
@Controller
@RequestMapping("/${table.className?lower_case}")
public class ${table.className}Controller extends BaseController {

	Logger log=LoggerFactory.getLogger(${table.className}Controller.class);
	
    @Autowired
    ${table.className}Service ${table.className?uncap_first}Service;
	
	/**
	 * 列表视图
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView list(HttpServletRequest request, HttpServletResponse response, ${table.className} ${table.className?uncap_first}) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/${table.className?uncap_first}/list");
		List<${table.className}> ${table.className?uncap_first}List = null;
		try {
			 ${table.className?uncap_first}List= ${table.className?uncap_first}Service.select(${table.className?uncap_first});
			 mv.addObject("data", ${table.className?uncap_first}List);
		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
			 mv.addObject("errorMsg", e.getMessage());
		}
		return mv;
	}

	/**
	 * 查询单条记录
	 */
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView get(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		try {
			${primaryKeyField.type} ${primaryKeyField.field} = request.getParameter("${primaryKeyField.field}");
			if (StringUtils.isNotEmpty(${primaryKeyField.field})) {
				${table.className} data = ${table.className?uncap_first}Service.selectOne(${primaryKeyField.field});
				mv.addObject("model", data);
			} else {
				mv.addObject("model", new ${table.className}());
			}

		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
		}

		mv.setViewName("admin/${table.className?uncap_first}/get");
		return mv;

	}

	/**
	 * 新增数据
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Object add(@RequestBody ${table.className} ${table.className?uncap_first}) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = ${table.className?uncap_first}Service.insert(${table.className?uncap_first});
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
	public Object edit(@RequestBody ${table.className} ${table.className?uncap_first}) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = ${table.className?uncap_first}Service.update(${table.className?uncap_first});
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
	public Object delete(@RequestParam(value="${primaryKeyField.field}") ${primaryKeyField.type} ${primaryKeyField.field}) {
		ModelAndView mv = new ModelAndView();
		try {
			int num = ${table.className?uncap_first}Service.deleteOne(${primaryKeyField.field});
			mv.addObject("success", num);
		} catch (Exception e) {
			log.error("出错："+e.getMessage(), e);
			mv.addObject("errorMsg", e.getMessage());
		}
		return mv;
	}

    
}
