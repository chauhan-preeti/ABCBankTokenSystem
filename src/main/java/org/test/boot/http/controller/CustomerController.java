package org.test.boot.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.boot.http.model.BaseResponse;
import org.test.boot.http.model.CustomerRequest;
import org.test.boot.http.model.CustomerResponse;
import org.test.boot.http.service.CustomerServices;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServices customerServices;
	
	@PostMapping("/api/v1/registerCustomeer")
	public BaseResponse<CustomerResponse> registerCustomer(@RequestBody CustomerRequest customerRequest){
		return customerServices.registerCustomer(customerRequest);
	}
}