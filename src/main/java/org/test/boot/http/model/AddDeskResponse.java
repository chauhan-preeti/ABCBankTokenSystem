package org.test.boot.http.model;

import org.test.boot.dao.model.DeskType;

public class AddDeskResponse {
	
	private Long id;
	private String deskName;	
	private DeskType deskType;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
