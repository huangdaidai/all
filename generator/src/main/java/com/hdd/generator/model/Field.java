package com.hdd.generator.model;

import com.hdd.generator.util.MyUtil;

/**
 * Created by page on 2017/6/12.
 */
public class Field {
    String field;
    String field_;
    String type;
    String allType;
    String collation;
    String nvll;
    String key;
    String defaults;
    String extra;
    String privileges;
    String comment;
    
    //驼峰式
    public String getField() {
        return MyUtil.a_b2aB(field);
    }

    //下划线式
    public String getField_() {
        return field_;
    }

    public Field setField(String field) {
        this.field = field;
        this.field_ = field;
        return this;
    }

    public String getType() {
        if(type.contains("int"))
            return "Integer";
        if(type.contains("char") || type.contains("text"))
            return "String";
        if(type.contains("date")||type.contains("time"))
            return "Date";
        if(type.contains("float")||type.contains("double")||type.contains("decimal"))
            return "BigDecimal";
        return type;
    }
    
    public String getAllType() {
    	if(type.contains("int"))
    		return "java.lang.Integer";
    	if(type.contains("char") || type.contains("text"))
    		return "java.lang.String";
    	if(type.contains("date")||type.contains("time"))
    		return "java.util.Date";
    	if(type.contains("float")||type.contains("double")||type.contains("decimal"))
    		return "java.math.BigDecimal";
    	return type;
    }

    public Field setType(String type) {
        this.type = type;
        return this;
    }

    public String getCollation() {
        return collation;
    }

    public Field setCollation(String collation) {
        this.collation = collation;
        return this;
    }

    public String getNvll() {
        return nvll;
    }

    public Field setNvll(String nvll) {
        this.nvll = nvll;
        return this;
    }

    public String getKey() {
        return key;
    }
    public Boolean getIsPrimaryKey() {
    	return key.equalsIgnoreCase("PRI");
    }

    public Field setKey(String key) {
        this.key = key;
        return this;
    }

    public String getDefaults() {
        return defaults;
    }

    public Field setDefaults(String defaults) {
        this.defaults = defaults;
        return this;
    }

    public String getExtra() {
        return extra;
    }

    public Field setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    public String getPrivileges() {
        return privileges;
    }

    public Field setPrivileges(String privileges) {
        this.privileges = privileges;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Field setComment(String comment) {
        this.comment = comment;
        return this;
    }

	@Override
	public String toString() {
		return "Field [field=" + field + ", field_=" + field_ + ", type=" + type + ", allType=" + allType
				+ ", collation=" + collation + ", nvll=" + nvll + ", key=" + key + ", defaults=" + defaults + ", extra="
				+ extra + ", privileges=" + privileges + ", comment=" + comment + "]";
	}

  
}
