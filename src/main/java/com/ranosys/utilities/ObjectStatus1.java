package com.ranosys.utilities;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;

public class ObjectStatus1 {

	private Row row;
	private Column column;
	private String status;

	public Row getRow() {
		return row;
	}

	public void setRow(Row row) {
		this.row = row;
	}

	public Column getColumn() {
		return column;
	}

	public void setColumn(Column column) {
		this.column = column;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
