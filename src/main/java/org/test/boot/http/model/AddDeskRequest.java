package org.test.boot.http.model;

import org.test.boot.dao.model.DeskType;

public class AddDeskRequest {
		
	private String deskName;	
	private DeskType deskType;	

	public String getDeskName() {
		return deskName;
	}

	public void setDeskName(String deskName) {
		this.deskName = deskName;
	}

	public DeskType getDeskType() {
		return deskType;
	}

	public void setDeskType(DeskType deskType) {
		this.deskType = deskType;
	}
}
