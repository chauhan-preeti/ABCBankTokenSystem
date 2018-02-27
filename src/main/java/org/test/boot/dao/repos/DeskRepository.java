package org.test.boot.dao.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.boot.dao.model.DeskManager;
import org.test.boot.dao.model.DeskManager.DeskType;

@Repository
public interface DeskRepository extends JpaRepository<DeskManager, Long> {
	public DeskManager findByDeskType(DeskType deskType);
}
