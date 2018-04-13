package org.rogenerator4j.util;

import org.rogenerator4j.model.Field;
import org.rogenerator4j.model.Table;

import java.util.*;

/**
 * Created by page on 2017/6/12.
 */
public class Maps {
    static Map<String,List<Field>> tables = new HashMap<String, List<Field>>();
    static Map<String,Table> classes = new HashMap<String, Table>();
    static String[] tablePrefixFilters = Config.get("tablePrefixFilters").split(","); 
    public static List<Field> put(String table,List<Field> fields){
    	Table tb = new Table();
    	tb.setTable(table);
    	String className = table;
    	for(String s: tablePrefixFilters){
    		className = className.replaceAll("(?i)"+s, ""); //.replace(s, "");
        }
    	tb.setClassName(MyUtil.a_b2AB(className));
    	tb.setComment("");
    	classes.put(table, tb);
    	
        return tables.put(table,fields);
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
}
