package org.rogenerator4j.model;

/**
 * Created by page on 2017/6/12.
 */
public class Table {
	String table;
	String className;
	String comment;

	@Override
	public String toString() {
		return table;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
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
