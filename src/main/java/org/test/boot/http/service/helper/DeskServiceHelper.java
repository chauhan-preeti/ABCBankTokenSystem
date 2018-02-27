package org.test.boot.http.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.boot.dao.repos.DeskRepository;

@Component
public class DeskServiceHelper {
	@SuppressWarnings("unused")
	@Autowired
	private DeskRepository deskRepository;
	
}
