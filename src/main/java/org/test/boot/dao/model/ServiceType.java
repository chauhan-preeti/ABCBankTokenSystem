package org.test.boot.dao.model;

public enum ServiceType {
	
	DEPOSIT(1), WITHDRAW(2);
	
	Integer serviceCode;
	
	private ServiceType(Integer serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Integer getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(Integer serviceCode) {
		this.serviceCode = serviceCode;
	}
}
