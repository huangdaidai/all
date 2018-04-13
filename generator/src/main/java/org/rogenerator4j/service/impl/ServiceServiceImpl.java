package org.rogenerator4j.service.impl;

import freemarker.template.TemplateException;

import org.rogenerator4j.model.Table;
import org.rogenerator4j.service.CreateService;
import org.rogenerator4j.service.ServiceService;
import org.rogenerator4j.util.Maps;
import org.rogenerator4j.util.MyUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by page on 2017/6/13.
 */
public class ServiceServiceImpl implements ServiceService {
    CreateService cs=CreateServiceImpl.getInstance();


    @Override
    public void createServices() throws IOException, TemplateException {
        String path = MyUtil.mkDir("service");

        List<String> tables = Maps.getTables();
        for (String table : tables) {
            Map<String, Object> root = new HashMap<String, Object>();
            Table tb = Maps.getTableClass(table);
            root.put("model", MyUtil.a_b2AB(table));
            root.put("tableClass", tb);
            cs.write2File(root, "Service.ftl", new File(path + File.separator + tb.getClassName() + "Service.java"));
        }
    }

    @Override
    public void createService(String table) throws IOException, TemplateException {
        String path = MyUtil.mkDir("service");
        Map<String, Object> root = new HashMap<String, Object>();
        Table tb = Maps.getTableClass(table);
        root.put("model", MyUtil.a_b2AB(table));
        root.put("tableClass", tb);
        cs.write2File(root, "Service.ftl", new File(path + File.separator + tb.getClassName() + "Service.java"));
    }

    @Override
    public void createServiceImpls() throws IOException, TemplateException {
        String path = MyUtil.mkDir("service.impl");

        List<String> tables = Maps.getTables();
        for (String table : tables) {
            Map<String, Object> root = new HashMap<String, Object>();
            Table tb = Maps.getTableClass(table);
            root.put("model", MyUtil.a_b2AB(table));
            root.put("tableClass", tb);
            cs.write2File(root, "ServiceImpl.ftl", new File(path + File.separator + tb.getClassName() + "ServiceImpl.java"));
        }
    }

    @Override
    public void createServiceImpl(String table) throws IOException, TemplateException {
        String path = MyUtil.mkDir("service.impl");
        Map<String, Object> root = new HashMap<String, Object>();
        Table tb = Maps.getTableClass(table);
        root.put("model", MyUtil.a_b2AB(table));
        root.put("tableClass",tb);
        cs.write2File(root, "ServiceImpl.ftl", new File(path + File.separator + tb.getClassName() + "ServiceImpl.java"));
    }
}
