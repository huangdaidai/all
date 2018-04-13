package org.rogenerator4j.service.impl;

import freemarker.template.TemplateException;

import org.rogenerator4j.model.Table;
import org.rogenerator4j.service.CreateService;
import org.rogenerator4j.service.FrontService;
import org.rogenerator4j.util.Config;
import org.rogenerator4j.util.Maps;
import org.rogenerator4j.util.MyUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by page on 2017/6/29.
 */
public class FrontServiceImpl implements FrontService{
    CreateService cs=CreateServiceImpl.getInstance();

    @Override
    public void createJss() throws IOException, TemplateException {
        String path= MyUtil.mkFrontDir("authscript");
        List<String> tables = Maps.getTables();
        for (String table : tables) {
            Map<String, Object> root = new HashMap<String, Object>();
            Table tb = Maps.getTableClass(table);
            root.put("model", MyUtil.a_b2AB(table));
            root.put("tableClass", tb);
            root.put("fields", Maps.getFields(table));
            cs.write2File(root, "Js.ftl", new File(path + File.separator + tb.getClassName() + "Script.js"));
        }
    }

    @Override
    public void createJs(String table) throws IOException, TemplateException {

    }

    @Override
    public void createJsps() throws IOException, TemplateException {
        String path= MyUtil.mkFrontDir("pages");
        List<String> tables = Maps.getTables();
        for (String table : tables) {
            Map<String, Object> root = new HashMap<String, Object>();
            Table tb = Maps.getTableClass(table);
            root.put("model", MyUtil.a_b2AB(table));
            root.put("tableClass", tb);
            root.put("fields", Maps.getFields(table));
            cs.write2File(root, "Jsp.ftl", new File(path + File.separator + tb.getClassName() + ".jsp"));
        }
    }

    @Override
    public void createJsp(String table) throws IOException, TemplateException {

    }
}
