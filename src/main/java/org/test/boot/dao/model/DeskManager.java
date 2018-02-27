package org.test.boot.dao.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity(name="DESK_MANAGER")
public class DeskManager {
	public enum DeskType{
		NORMAL,NEW,PREVILIDGED
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Basic
	@Column(name="DESK_NAME")
	private String deskName;
	
	@Basic
	@Column(name="DESK_TYPE")
	@Enumerated(EnumType.STRING)
	private DeskType deskType;
	
	@Transient
	private List<Token> tokenList;
	
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

	public List<Token> getTokenList() {
		return tokenList;
	}

	public void setTokenList(List<Token> tokenList) {
		this.tokenList = tokenList;
	}

	
	
}
