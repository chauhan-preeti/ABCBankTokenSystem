package org.test.boot.dao.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TOKEN")
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tokenId;

	@Basic
	@Column(name = "ISSUE_DATE")
	private Date issueDate;
	
	@Basic
	@Column(name = "MODIFY_DATE")
	private Date modifyDate;

	@Basic
	@Column(name = "UPDATED_BY")
	private String updatedBy;

	@Basic
	@Column(name = "TOKEN_TYPE")
	@Enumerated(EnumType.STRING)
	private TokenType tokenType;

	@Basic
	@Column(name = "TOKEN_STATUS")
	@Enumerated(EnumType.STRING)
	private TokenStatus tokenStatus;
	
	@Basic
	@Column(name = "SERVICE_TYPE")
	@Enumerated(EnumType.STRING)
	private ServiceType serviceType;

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public Long getTokenId() {
		return tokenId;
	}

	public void setTokenId(Long tokenId) {
		this.tokenId = tokenId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public TokenType getTokenType() {
		return tokenType;
	}

	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}

	public TokenStatus getTokenStatus() {
		return tokenStatus;
	}

	public void setTokenStatus(TokenStatus tokenStatus) {
		this.tokenStatus = tokenStatus;
	}

}
