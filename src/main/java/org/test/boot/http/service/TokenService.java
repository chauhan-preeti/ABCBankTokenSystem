package org.test.boot.http.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.test.boot.dao.model.Token;
import org.test.boot.http.model.BaseResponse;
import org.test.boot.http.model.TokenRequest;
import org.test.boot.http.model.TokenResponse;
import org.test.boot.http.model.TokenStatusUpdateRequest;
import org.test.boot.http.model.TokenStatusUpdateResponse;
import org.test.boot.http.service.helper.TokenServiceHelper;
import org.test.boot.http.utils.ResponseUtils;

@Service
public class TokenService {
	
	@Autowired
	private TokenServiceHelper tokenServiceHelper;
	
	public BaseResponse<TokenResponse> generateToken(TokenRequest tokenRequest) {
		
		Token token = tokenServiceHelper.generateNewToken(tokenRequest);
		TokenResponse tokenResponse = new TokenResponse();
		tokenResponse.setTokenId(token.getTokenId());
		return ResponseUtils.success("data", tokenResponse);
	}
	
	public BaseResponse<TokenStatusUpdateResponse> updateToken(TokenStatusUpdateRequest tokenStatusUpdateRequest) {
		
		Token token = tokenServiceHelper.updateTokenStatus(tokenStatusUpdateRequest);
		TokenStatusUpdateResponse tokenStatusUpdateResponse = new TokenStatusUpdateResponse();
		tokenStatusUpdateResponse.setToken(token);
		
		return ResponseUtils.success("data", tokenStatusUpdateResponse);
	}

	public BaseResponse<List<Token>> listToken() {
		return ResponseUtils.success("data", tokenServiceHelper.listToken());
	}
	
	
}
