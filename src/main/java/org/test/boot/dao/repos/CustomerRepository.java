package org.test.boot.dao.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.test.boot.dao.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("from Customer where mobileNumber = ?1")
	public Customer findByCustomerMobileAndCustomerName(String customerMobile, String customerName);

	public Customer findByCustomerMobile(String customerMobile);
}
