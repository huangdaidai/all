package com.hdd.generator.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hdd.generator.model.Table;
import com.hdd.generator.util.TableMaps;
import com.hdd.generator.util.MyUtil;

import freemarker.template.TemplateException;

/**
 * Created by page on 2017/6/29.
 */
public class FrontService {
	CreateService cs=CreateService.getInstance();


    public void createJss() throws IOException, TemplateException {
        String path= MyUtil.mkFrontDir("authscript");
        List<String> tables = TableMaps.getTables();
        for (String table : tables) {
            Map<String, Object> root = new HashMap<String, Object>();
            Table tb = TableMaps.getTableClass(table);
            root.put("model", MyUtil.a_b2AB(table));
            root.put("tableClass", tb);
            root.put("fields", TableMaps.getFields(table));
            cs.write2File(root, "Js.ftl", new File(path + File.separator + tb.getClassName() + "Script.js"));
        }
    }


    public void createJs(String table) throws IOException, TemplateException {

    }


    public void createJsps() throws IOException, TemplateException {
        String path= MyUtil.mkFrontDir("pages");
        List<String> tables = TableMaps.getTables();
        for (String table : tables) {
            Map<String, Object> root = new HashMap<String, Object>();
            Table tb = TableMaps.getTableClass(table);
            root.put("model", MyUtil.a_b2AB(table));
            root.put("tableClass", tb);
            root.put("fields", TableMaps.getFields(table));
            cs.write2File(root, "Jsp.ftl", new File(path + File.separator + tb.getClassName() + ".jsp"));
        }
    }


    public void createJsp(String table) throws IOException, TemplateException {

    }
}
