package org.rogenerator4j.service.impl;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.rogenerator4j.App;
import org.rogenerator4j.service.CreateService;
import org.rogenerator4j.util.Config;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Date;
import java.util.Map;

/**
 * Created by page on 2017/6/13.
 */
public class CreateServiceImpl implements CreateService{

    private CreateServiceImpl(){}

    private static class NESTED{
        public static CreateServiceImpl cs=new CreateServiceImpl();
    }

    public static CreateServiceImpl getInstance(){
        return NESTED.cs;
    }

    Logger logger= Logger.getLogger("");
    Configuration configuration=new Configuration();
    {
        configuration.setDefaultEncoding("UTF-8");
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setClassForTemplateLoading(CreateServiceImpl.class,"/temp");
         
    }

    @Override
    public String getString(Map<String, Object> root, String ftlName) throws IOException, TemplateException {

        root.put("now",new Date());
        Template template=getTemp(ftlName);
        StringWriter sw=new StringWriter();
        template.process(root,sw);
        return sw.toString();
    }

    @Override
    public void write2File(Map<String, Object> root, String ftlName, File file) throws IOException, TemplateException {
        root.put("now",new Date());
        root.put("package", Config.get("package"));
        root.put("author", Config.get("author"));
        Template template=getTemp(ftlName);
        template.process(root,new FileWriter(file));
        logger.info("写入 "+file.toString()+ " [ 成功 ]");
        
        configuration.clearTemplateCache();
    }
    @Override
    public void clearTemplateCache( ){
        try {
        	 configuration.clearTemplateCache();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    private Template getTemp(String name){
        try {
            return  configuration.getTemplate(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
