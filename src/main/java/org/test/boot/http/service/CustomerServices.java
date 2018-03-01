package org.test.boot.http.service;

import java.util.Date;

import org.test.boot.http.model.BaseResponse;
import org.test.boot.http.model.CustomerRequest;
import org.test.boot.http.model.CustomerResponse;
import org.test.boot.http.service.helper.CustomerServiceHelper;
import org.test.boot.http.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.boot.dao.model.Customer;

@Service 
public class CustomerServices {
	
	@Autowired
	private CustomerServiceHelper customerServiceHelper;
	
	public BaseResponse<CustomerResponse> registerCustomer(CustomerRequest customerRequest) {
		CustomerResponse customerResponse = new CustomerResponse();
		Customer customer = customerServiceHelper.registerCustomer(customerRequest);
		customerResponse.setCustomerName(customer.getCustomerName());
		customerResponse.setCustomerMobile(customer.getCustomerMobile());	
		
		return ResponseUtils.success("test", customerResponse);
	}
}
