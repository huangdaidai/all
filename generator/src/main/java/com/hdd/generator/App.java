package com.hdd.generator;

import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.Logger;

import com.hdd.generator.db.TableDao;
import com.hdd.generator.service.ControllerService;
import com.hdd.generator.service.CreateService;
import com.hdd.generator.service.DaoService;
import com.hdd.generator.service.FrontService;
import com.hdd.generator.service.ModelService;
import com.hdd.generator.service.ServiceService;
import com.hdd.generator.util.TableMaps;

import freemarker.template.TemplateException;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws IOException, TemplateException, ParseException {
        Logger logger= Logger.getLogger("");
        TableDao td=new TableDao();
        td.loadTables();
        logger.info("数据库加载完成");
        ModelService ms=new ModelService();
        DaoService ds=new DaoService();
        ServiceService ss=new ServiceService();
        ControllerService cs=new ControllerService();
        FrontService fs=new FrontService();
        
        TableMaps.print();
 
        CreateService _CreateService =CreateService.getInstance();
        ms.createModels();
		ds.createDaos();
		ds.createDaoImpls();
		ds.createMappers();
		ss.createServices();
		ss.createServiceImpls();
		cs.createControllers();
		cs.createBaseController();
//		fs.createJss();
//		fs.createJsps();
        
        _CreateService.clearTemplateCache();
    }
}
