package org.rogenerator4j.service.impl;

import freemarker.template.TemplateException;

import org.rogenerator4j.model.Table;
import org.rogenerator4j.service.CreateService;
import org.rogenerator4j.service.DaoService;
import org.rogenerator4j.util.Maps;
import org.rogenerator4j.util.MyUtil;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by page on 2017/6/13.
 */
public class DaoServiceImpl implements DaoService {
    CreateService cs=CreateServiceImpl.getInstance();

    @Override
    public void createDaos() throws IOException, TemplateException {
        String path= MyUtil.mkDir("dao");
        List<String> tables = Maps.getTables();
        for (String table : tables) {
            Map<String, Object> root = new HashMap<String, Object>();
            Table tb = Maps.getTableClass(table);
            root.put("model", MyUtil.a_b2AB(table));
            root.put("tableClass", tb);
            cs.write2File(root, "Dao.ftl", new File(path + File.separator + tb.getClassName() + "Dao.java"));
        }
    }
    @Override
    public void createDaoImpls() throws IOException, TemplateException {
    	String path= MyUtil.mkDir("dao.impl");
    	List<String> tables = Maps.getTables();
    	for (String table : tables) {
    		Map<String, Object> root = new HashMap<String, Object>();
    		Table tb = Maps.getTableClass(table);
    		root.put("model", MyUtil.a_b2AB(table));
    		root.put("tableClass", tb);
    		cs.write2File(root, "DaoImpl.ftl", new File(path + File.separator + tb.getClassName() + "DaoImpl.java"));
    	}
    }

    @Override
    public void createDao(String table) throws IOException, TemplateException {
        String path= MyUtil.mkDir("dao");
        Map<String, Object> root = new HashMap<String, Object>();
        Table tb = Maps.getTableClass(table);
        root.put("model", MyUtil.a_b2AB(table));
        root.put("tableClass", Maps.getTableClass(table));
        cs.write2File(root, "Dao.ftl", new File(path + File.separator + tb.getClassName()+ "Dao.java"));
    }
    
    @Override
	public void createDaoImpl(String table) throws IOException, TemplateException {
    	String path= MyUtil.mkDir("dao");
        Map<String, Object> root = new HashMap<String, Object>();
        Table tb = Maps.getTableClass(table);
        root.put("model", MyUtil.a_b2AB(table));
        root.put("tableClass", Maps.getTableClass(table));
        cs.write2File(root, "DaoImpl.ftl", new File(path + File.separator + tb.getClassName()+ "DaoImpl.java"));
    
	}
    
    @Override
    public void createMappers() throws IOException, TemplateException {
        String path= MyUtil.mkDir("dao.mapper");
        List<String> tables = Maps.getTables();
        for (String table : tables) {
            Map<String, Object> root = new HashMap<String, Object>();
            Table tb = Maps.getTableClass(table);
            root.put("model", MyUtil.a_b2AB(table));
            root.put("tableClass", tb);
            root.put("table",table);
            root.put("fields", Maps.getFields(table));
            System.out.println(Maps.getFields(table));
            cs.write2File(root, "Mapper.ftl", new File(path + File.separator + tb.getClassName() + "Mapper.xml"));
        }
    }

    @Override
    public void createMapper(String table) throws IOException, TemplateException {
        String path= MyUtil.mkDir("mapper");
        Map<String, Object> root = new HashMap<String, Object>();
        Table tb = Maps.getTableClass(table);
        root.put("model", MyUtil.a_b2AB(table));
        root.put("tableClass", tb);
        root.put("table",table);
        root.put("fields", Maps.getFields(table));
        cs.write2File(root, "Mapper.ftl", new File(path + File.separator + tb.getClassName() + "Mapper.xml"));
    }
}
