package com.hdd.generator.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.hdd.generator.model.Field;
import com.hdd.generator.model.Table;

/**
 * 
 * @author hdd
 * 2018年4月15日
 *
 */
public class TableMaps {
    static Map<String,List<Field>> tables = new HashMap<String, List<Field>>();
    static Map<String,Table> classes = new HashMap<String, Table>();
    static List<Table> tableList=new ArrayList<>();
    static String[] tablePrefixFilters = Config.get("tablePrefixFilters").split(","); 
    public static List<Field> put(String tableName,List<Field> fields){
    	Table tb = new Table();
    	tb.setTableName(tableName);
    	String className = tableName;
    	for(String s: tablePrefixFilters){
    		className = className.replaceAll("(?i)"+s, ""); //.replace(s, "");
        }
    	tb.setClassName(MyUtil.a_b2AB(className));
    	tb.setComment("");
    	classes.put(tableName, tb);
    	tableList.add(tb);
        return tables.put(tableName,fields);
    }

    public static List<Field> getFields(String table){
        return tables.get(table);
    }

    public static Field getPrimaryKeyField(String table){
    	List<Field>  fields= tables.get(table);
    	for (Field field : fields) {
			if (field != null && field.getIsPrimaryKey()) {
				return field;
			}
		}
    	Field f = new Field(); 
    	f.setType("int");
    	return f; 
    }

    
    public static Table getTableClass(String table){
        return classes.get(table);
    }
    
    public static List<String> getTables(){
        Set<Map.Entry<String, List<Field>>> set=tables.entrySet();
        List<String> tables=new ArrayList<String>(set.size());
       
        for(Map.Entry<String,List<Field>> e:set){
            tables.add(e.getKey());
        }
        return tables;
    }

    public static void print(){
        System.out.println("一共 ："+tables.size()+" 张表。");
        Set<Map.Entry<String, List<Field>>> set=tables.entrySet();
        
        Set<Map.Entry<String, Table>> setClasses=classes.entrySet();
        for(Map.Entry<String,List<Field>> e:set){
            System.out.println("表： "+e.getKey());
            System.out.println("---------------------");
            List<Field> fields=e.getValue();
            for(int i=0;i<fields.size();i++){
                System.out.println(fields.get(i).getField());
            }
            
            System.out.println("----------Class-----------");
            Table tb = classes.get(e.getKey());
            System.out.println(tb.getClassName() );
        }
        System.out.println();
    }
    
    public static Map<String,Object> getOneTableMsgMap(String tableName){
    	Map<String,Object> m=new HashMap<>();
    	Table tb = TableMaps.getTableClass(tableName);
    	 m.put("className", MyUtil.a_b2AB(tableName));
         m.put("table", tb);
         List<Field> fields=TableMaps.getFields(tableName);
         m.put("fields", fields);
         m.put("primaryKeyField", TableMaps.getPrimaryKeyField(tableName));
         Set<String> allTypes=new HashSet<>();
         for(Field f:fields){
         	allTypes.add(f.getAllType());
         }
         m.put("allTypes",allTypes);
    	return m;
    }
    
    public static List<Map<String,Object>> getTablesMsgList(){
    	List<Map<String,Object>> list=new ArrayList<>();
    	List<String> tableList=TableMaps.getTables();
    	for (String tableName : tableList) {
            list.add(getOneTableMsgMap(tableName));
		}
    	return list;
    }

	public static List<Table> getTableList() {
		return tableList;
	}
    
}
