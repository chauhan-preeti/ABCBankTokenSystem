package org.test.boot.http.service.helper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.boot.dao.model.Customer;
import org.test.boot.dao.repos.CustomerRepository;
import org.test.boot.http.model.CustomerRequest;

@Component
public class CustomerServiceHelper {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer registerCustomer(CustomerRequest customerRequest) {

		Customer customer = new Customer();

		customer.setCustomerName(customerRequest.getCustomerName());
		customer.setCustomerMobile(customerRequest.getCustomerMobile());
		customer.setCustomerType(customerRequest.getCustomerType());
		customer.setRegistrationDate(new Date());

		customerRepository.save(customer);

		return customer;
	}
}
