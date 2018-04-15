package com.hdd.generator.util;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;

import com.hdd.generator.model.Field;

/**
 * Created by page on 2017/6/13.
 */
public class MyUtil {
    public static String a_b2aB(String str){
        if(str.contains("_")){
            String[] temp=str.split("_");
            for(int i=1;i<temp.length;i++){
                temp[0]+=temp[i].substring(0,1).toUpperCase()+temp[i].substring(1);
            }
            return temp[0].substring(0,1).toLowerCase()+temp[0].substring(1);
        }
        return str;
    }

    public static String a_b2AB(String str) {
        StringBuilder sb=new StringBuilder();
        String[] temp = str.split("_");
        for (int i = 0; i < temp.length; i++) {
            sb.append(temp[i].substring(0, 1).toUpperCase() + temp[i].substring(1));
        }
        return sb.toString();
    }
    public static List<Field> dbFields2BeanFields(String table) {
    	List<Field> fields=TableMaps.getFields(table);
    	if(fields==null || fields.isEmpty()){
    		return null;
    	}
    	for(Field field:fields){
    		String[] temp = field.getField_().split("_");
    		String newfield="";
            for (String s:temp) {
            	newfield +=s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
            }
            newfield=newfield.substring(0,1).toLowerCase() + newfield.substring(1);
            field.setField(newfield);
    	}
    	return fields;
    }
    public static String getPath(){
        return Config.get("path")+Config.get("package").replace(".", File.separator);
    }

    public static String mkDir(String name){
        Logger logger= Logger.getLogger("");
        String path= (getPath()+File.separator+name).replace(".", File.separator);
        File f=new File(path);
        if(!f.isDirectory()) {
            f.mkdirs();
            logger.info("创建目录：" + path + " [ 成功 ]");
        }
        return path;
    }

    public static String mkFrontDir(String name){
        Logger logger= Logger.getLogger("");
        String path= Config.get("path")+File.separator+"static"+File.separator+name;
        File f=new File(path);
        if(!f.isDirectory()){
            f.mkdirs();
            logger.info("创建目录：" + path + " [ 成功 ]");
        }
        return path;
    }
}
