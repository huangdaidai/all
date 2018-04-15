package com.hdd.generator.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.hdd.generator.model.Field;
import com.hdd.generator.util.Config;
import com.hdd.generator.util.TableMaps;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by page on 2017/6/12.
 */
public class TableDao {

    Log log=LogFactory.getLog(TableDao.class);

    public void loadTables(){
        String sql="show tables;";
        PreparedStatement ps=null;
        try {
            ps=DBcon.getCon().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            String tableOnly=Config.get("tableOnly");
            String tableExcepts=Config.get("tableExcepts");
            List<String> onlyList=null;
            List<String>  exceptList=null;
            if(StringUtils.isNotBlank(tableOnly)){
        		onlyList = Arrays.asList(tableOnly.split(","));
        	}else if(StringUtils.isNotBlank(tableExcepts)){
        		exceptList = Arrays.asList(tableExcepts.split(","));
        	}
            while(rs.next()){
            	String tableName = rs.getString(1);
            	if(StringUtils.isNotBlank(tableOnly)){
            		if(onlyList.contains(tableName)){
            			TableMaps.put(tableName,loadFields(tableName));
            		}
            	}else if(StringUtils.isNotBlank(tableExcepts)){
					if (!exceptList.contains(tableName)) {
						 TableMaps.put(tableName,loadFields(tableName));
					}
            	}else{
            		TableMaps.put(tableName,loadFields(tableName));
            	}
            		
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Field> loadFields(String table){
        String sql="show full columns from "+table+";";
        PreparedStatement ps=null;
        List<Field> fields=new ArrayList<Field>();
        try {
            ps=DBcon.getCon().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            	System.out.println(rs.getString(1));
                Field field=new Field();
                field.setField(rs.getString(1));
                field.setType(rs.getString(2));
                field.setCollation(rs.getString(3));
                field.setNvll(rs.getString(4));
                field.setKey(rs.getString(5));
                field.setDefaults(rs.getString(6));
                field.setExtra(rs.getString(7));
                field.setPrivileges(rs.getString(8));
                field.setComment(rs.getString(9));
                fields.add(field);
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fields;
    }
}
