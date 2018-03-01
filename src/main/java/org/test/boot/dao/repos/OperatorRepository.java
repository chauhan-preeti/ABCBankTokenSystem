package org.test.boot.dao.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.boot.dao.model.Operator;

@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {

	public Operator findByOperatorMobile(String operatorMobile);
}