package org.rogenerator4j.service.impl;

import freemarker.template.TemplateException;

import org.rogenerator4j.model.Table;
import org.rogenerator4j.service.ControllerService;
import org.rogenerator4j.service.CreateService;
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
public class ControllerServiceImpl implements ControllerService {

    CreateService cs=CreateServiceImpl.getInstance();
    @Override
    public void createControllers() throws IOException, TemplateException {
        String path = MyUtil.mkDir("controller");

        List<String> tables = Maps.getTables();
        for (String table : tables) {
            Map<String, Object> root = new HashMap<String, Object>();
            Table tb = Maps.getTableClass(table);
            root.put("model", MyUtil.a_b2AB(table));
            root.put("tableClass", tb);
            root.put("primaryKeyField", Maps.getPrimaryKeyField(table));
            cs.write2File(root, "Controller.ftl", new File(path + File.separator +tb.getClassName() + "Controller.java"));
        }
    }

    @Override
    public void createController(String table) throws IOException, TemplateException {
        String path = MyUtil.mkDir("controller");
        Map<String, Object> root = new HashMap<String, Object>();
        Table tb = Maps.getTableClass(table);
        root.put("model", MyUtil.a_b2AB(table));
        root.put("tableClass", tb);
        root.put("primaryKeyField", Maps.getPrimaryKeyField(table));
        cs.write2File(root, "Controller.ftl", new File(path + File.separator + tb.getClassName() + "Controller.java"));
    }
}
