package com.hdd.generator.model;

/**
 * 
 * @author hdd
 * 2018年4月15日
 *
 */
public class Table {
	String tableName;
	String className;
	String comment;

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Table [tableName=" + tableName + ", className=" + className + ", comment=" + comment + "]";
	}

	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
