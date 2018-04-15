package com.hdd.generator.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;

import com.hdd.generator.util.Config;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Created by page on 2017/6/13.
 */
public class CreateService{

    private CreateService(){}

    private static class NESTED{
        public static CreateService cs=new CreateService();
    }

    public static CreateService getInstance(){
        return NESTED.cs;
    }

    Logger logger= Logger.getLogger("");
    Configuration configuration=new Configuration();
    {
        configuration.setDefaultEncoding("UTF-8");
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setClassForTemplateLoading(CreateService.class,"/temp");
         
    }

   
    public String getString(Map<String, Object> root, String ftlName) throws IOException, TemplateException {

        root.put("now",new Date());
        Template template=getTemp(ftlName);
        StringWriter sw=new StringWriter();
        template.process(root,sw);
        return sw.toString();
    }

   
    public void write2File(Map<String, Object> root, String ftlName, File file) throws IOException, TemplateException {
        root.put("now",new Date());
        root.put("package", Config.get("package"));
        root.put("author", Config.get("author"));
        Template template=getTemp(ftlName);
        template.process(root,new FileWriter(file));
        logger.info("写入 "+file.toString()+ " [ 成功 ]");
        
        configuration.clearTemplateCache();
    }
   
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
