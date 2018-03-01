package org.test.boot.http.model;

import org.test.boot.dao.model.ServiceType;

public class TokenRequest {
	String mobileNumber;
	
	ServiceType serviceType;

	public ServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(ServiceType serviceType) {
		this.serviceType = serviceType;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
}
