package org.test.boot.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.boot.http.model.AddDeskRequest;
import org.test.boot.http.model.AddDeskResponse;
import org.test.boot.http.model.BaseResponse;
import org.test.boot.http.model.DeskRequest;
import org.test.boot.http.model.DeskResponse;
import org.test.boot.http.service.DeskServices;

@RestController
public class DeskController {

	@Autowired
	private DeskServices deskServices;
	
	@PostMapping("/api/v1/deskStatus")
	public BaseResponse<DeskResponse> deskStatus(@RequestBody DeskRequest deskRequest){
		return deskServices.fetchDeskDetails(deskRequest);
	}
	
	@PostMapping("/api/v1/addDesk")
	public BaseResponse<AddDeskResponse> addNewDesk(@RequestBody AddDeskRequest addDeskRequest){
		return deskServices.addNewDesk(addDeskRequest);
	}
}
