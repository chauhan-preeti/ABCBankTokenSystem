package org.test.boot.http.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.boot.dao.model.DeskManager;
import org.test.boot.dao.repos.DeskRepository;
import org.test.boot.http.model.AddDeskRequest;
import org.test.boot.http.model.DeskRequest;

@Component
public class DeskServiceHelper {
	@Autowired
	private DeskRepository deskRepository;

	public DeskManager getTokenList(DeskRequest deskRequest) {
		DeskManager deskManager = deskRepository.findById(deskRequest.getDeskId());
		return deskManager;
	}
	
	public DeskManager addNewDesk(AddDeskRequest addDeskRequest) {
		DeskManager deskManager = new DeskManager();
		deskManager.setDeskName(addDeskRequest.getDeskName());
		deskManager.setDeskType(addDeskRequest.getDeskType());
		
		deskRepository.save(deskManager);
		return deskManager;
	}
}
