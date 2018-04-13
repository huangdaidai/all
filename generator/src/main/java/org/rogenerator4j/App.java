package org.rogenerator4j;

import java.io.IOException;
import java.text.ParseException;

import org.apache.log4j.Logger;
import org.rogenerator4j.db.TableDao;
import org.rogenerator4j.service.ControllerService;
import org.rogenerator4j.service.CreateService;
import org.rogenerator4j.service.DaoService;
import org.rogenerator4j.service.FrontService;
import org.rogenerator4j.service.ModelService;
import org.rogenerator4j.service.ServiceService;
import org.rogenerator4j.service.impl.ControllerServiceImpl;
import org.rogenerator4j.service.impl.CreateServiceImpl;
import org.rogenerator4j.service.impl.DaoServiceImpl;
import org.rogenerator4j.service.impl.FrontServiceImpl;
import org.rogenerator4j.service.impl.ModelServiceImpl;
import org.rogenerator4j.service.impl.ServiceServiceImpl;
import org.rogenerator4j.util.Maps;

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
        ModelService ms=new ModelServiceImpl();
        DaoService ds=new DaoServiceImpl();
        ServiceService ss=new ServiceServiceImpl();
        ControllerService cs=new ControllerServiceImpl();
        FrontService fs=new FrontServiceImpl();
        
        Maps.print();
 
        CreateService _CreateService =CreateServiceImpl.getInstance();
//        ms.createModels();
//		ds.createDaos();
		ds.createMappers();
//		ss.createServices();
//		cs.createControllers();
//		fs.createJss();
//		fs.createJsps();
        
        _CreateService.clearTemplateCache();
    }
}
