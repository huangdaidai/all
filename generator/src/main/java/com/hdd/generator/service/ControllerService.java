package com.hdd.generator.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.hdd.generator.model.Table;
import com.hdd.generator.util.MyUtil;
import com.hdd.generator.util.TableMaps;

import freemarker.template.TemplateException;

/**
 * @author hdd 2018年4月14日
 *
 */
public class ControllerService {

	CreateService cs = CreateService.getInstance();

	public void createControllers() throws IOException, TemplateException {
		String path = MyUtil.mkDir("controller");
		List<Map<String, Object>> list = TableMaps.getTablesMsgList();
		for (Map<String, Object> m : list) {
			String className = ((Table) m.get("table")).getClassName();
			cs.write2File(m, "Controller.ftl", new File(path + File.separator + className + "Controller.java"));
		}
	}
}
