package org.rogenerator4j.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.rogenerator4j.model.Field;
import org.rogenerator4j.util.Config;
import org.rogenerator4j.util.Maps;
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
        	List<String> tableOnlys = Arrays.asList(Config.get("tableOnly").split(","));
        	List<String>  tableExcepts = Arrays.asList(Config.get("tableExcepts").split(","));
            ps=DBcon.getCon().prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
            	String tableName = rs.getString(1);
            	if(tableOnlys!=null && !tableOnlys.isEmpty()){
            		if(tableOnlys.contains(tableName)){
            			Maps.put(tableName,loadFields(tableName));
            		}
            	}else if(tableExcepts!=null && !tableExcepts.isEmpty()){
					if (!tableExcepts.contains(tableName)) {
						 Maps.put(tableName,loadFields(tableName));
					}
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
