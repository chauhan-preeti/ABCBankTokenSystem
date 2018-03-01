package org.test.boot.http.service;

import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.boot.dao.model.DeskManager;
import org.test.boot.dao.model.Token;
import org.test.boot.http.model.AddDeskRequest;
import org.test.boot.http.model.AddDeskResponse;
import org.test.boot.http.model.BaseResponse;
import org.test.boot.http.model.DeskRequest;
import org.test.boot.http.model.DeskResponse;
import org.test.boot.http.service.helper.DeskServiceHelper;
import org.test.boot.http.utils.ResponseUtils;

@Service
public class DeskServices {

	@Autowired
	DeskServiceHelper deskServiceHelper;

	public boolean migrateTokenToDesk(Token token, DeskManager source, DeskManager dest) {

		ListIterator<Token> itr = source.getTokenList().listIterator();
		while (itr.hasNext()) {
			if (itr.next().getTokenId().equals(token.getTokenId())) {
				itr.remove();
			}
		}
		source.getTokenList().add(token);
		return true;
	}

	public BaseResponse<DeskResponse> fetchDeskDetails(DeskRequest deskRequest) {

		DeskManager deskManager = deskServiceHelper.getTokenList(deskRequest);
		DeskResponse deskResponse = new DeskResponse();
		deskResponse.setName(deskManager.getDeskName());
		deskResponse.setWaitingList(deskManager.getTokenList());

		return ResponseUtils.success("test", deskResponse);
	}

	public BaseResponse<AddDeskResponse> addNewDesk(AddDeskRequest addDeskRequest) {

		DeskManager deskManager = deskServiceHelper.addNewDesk(addDeskRequest);
		AddDeskResponse addDeskResponse = new AddDeskResponse();
		addDeskResponse.setDeskName(deskManager.getDeskName());
		addDeskResponse.setDeskType(deskManager.getDeskType());

		return ResponseUtils.success("test", addDeskResponse);
	}
}
