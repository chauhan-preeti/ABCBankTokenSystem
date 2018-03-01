package org.test.boot.dao.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.test.boot.dao.model.DeskManager;
import org.test.boot.dao.model.DeskType;

@Repository
public interface DeskRepository extends JpaRepository<DeskManager, Long> {
	public DeskManager findByDeskType(DeskType deskType);
	
	@Query("FROM org.test.boot.dao.model.DeskManager dm where dm.id = ?1")
	public DeskManager findById(Long id);
}
