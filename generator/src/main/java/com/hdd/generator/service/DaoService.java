package com.hdd.generator.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hdd.generator.model.Table;
import com.hdd.generator.util.MyUtil;
import com.hdd.generator.util.TableMaps;

import freemarker.template.TemplateException;

/**
 * 
 * @author hdd 2018年4月15日
 *
 */
public class DaoService {
	
	CreateService cs = CreateService.getInstance();

	public void createDaos() throws IOException, TemplateException {
		String path = MyUtil.mkDir("dao");
		
		List<Map<String, Object>> list = TableMaps.getTablesMsgList();
		for (Map<String, Object> m : list) {
			String className = ((Table) m.get("table")).getClassName();
			cs.write2File(m, "dao.ftl", new File(path + File.separator + className + "Dao.java"));
		}
	}
	
	public void createDaoImpls() throws IOException, TemplateException {
		String path = MyUtil.mkDir("dao.impl");
		
		List<Map<String, Object>> list = TableMaps.getTablesMsgList();
		for (Map<String, Object> m : list) {
			String className = ((Table) m.get("table")).getClassName();
			cs.write2File(m, "daoImpl.ftl", new File(path + File.separator + className + "DaoImpl.java"));
		}
	}

	public void createMappers() throws IOException, TemplateException {
		String path = MyUtil.mkDir("dao.mapper");
		List<Map<String, Object>> list = TableMaps.getTablesMsgList();
		for (Map<String, Object> m : list) {
			String className = ((Table) m.get("table")).getClassName();
			cs.write2File(m, "mapper.ftl", new File(path + File.separator + className + "Mapper.xml"));
		}
	}

}
