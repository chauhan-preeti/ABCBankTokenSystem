package org.test.boot.http.service;

import java.util.ListIterator;

import org.springframework.stereotype.Service;
import org.test.boot.dao.model.DeskManager;
import org.test.boot.dao.model.Token;
import org.test.boot.http.model.BaseResponse;
import org.test.boot.http.model.DeskRequest;
import org.test.boot.http.model.DeskResponse;
import org.test.boot.http.utils.ResponseUtils;

@Service
public class DeskServices {
	
	public boolean migrateTokenToDesk(Token token,DeskManager source, DeskManager dest) {
		
		ListIterator<Token> itr = source.getTokenList().listIterator();
		while(itr.hasNext())
		{
			if (itr.next().getTokenId().equals(token.getTokenId()))
			{
				itr.remove();
			}
		}
		source.getTokenList().add(token);		
		return true;
	}
	
	public BaseResponse<DeskResponse> fetchDeskDetails(DeskRequest deskRequest) {
		return ResponseUtils.success("test", new DeskResponse());
	}
}
