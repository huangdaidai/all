package org.rogenerator4j.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.rogenerator4j.model.Field;
import org.rogenerator4j.model.Table;
import org.rogenerator4j.service.CreateService;
import org.rogenerator4j.service.ModelService;
import org.rogenerator4j.util.Maps;
import org.rogenerator4j.util.MyUtil;

import freemarker.template.TemplateException;

/**
 * Created by page on 2017/6/12.
 */
public class ModelServiceImpl implements ModelService {
    CreateService cs = CreateServiceImpl.getInstance();

    @Override
    public int createModels() throws IOException, TemplateException {
        String path = MyUtil.mkDir("model");
        List<String> tables = Maps.getTables();
        for (String table : tables) {
            Map<String, Object> root = new HashMap<String, Object>();
            Table tb = Maps.getTableClass(table);
            root.put("model", MyUtil.a_b2AB(table));
            root.put("tableClass", tb);
            List<Field> fields=Maps.getFields(table);
            root.put("fields",fields);
            Set<String> allTypes=new HashSet<>();
            for(Field f:fields){
            	allTypes.add(f.getAllType());
            }
            root.put("allTypes",allTypes);
            cs.write2File(root, "Model.ftl", new File(path + File.separator + tb.getClassName() + ".java"));
        }
        return 0;
    }

    @Override
    public int createModel(String table) throws IOException, TemplateException {
        String path = MyUtil.mkDir("model");
        Map<String, Object> root = new HashMap<String, Object>();
        Table tb = Maps.getTableClass(table);
        root.put("model", MyUtil.a_b2AB(table));
        root.put("tableClass", tb);
        root.put("fields", Maps.getFields(table));
        cs.write2File(root, "Model.ftl", new File(path + File.separator + tb.getClassName() + ".java"));
        return 0;
    }
}
