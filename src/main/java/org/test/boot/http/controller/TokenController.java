package org.test.boot.http.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.test.boot.dao.model.Token;
import org.test.boot.http.model.BaseResponse;
import org.test.boot.http.model.TokenRequest;
import org.test.boot.http.model.TokenResponse;
import org.test.boot.http.model.TokenStatusUpdateRequest;
import org.test.boot.http.model.TokenStatusUpdateResponse;
import org.test.boot.http.service.TokenService;

@RestController
public class TokenController {

	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/api/v1/generateToken")
	public BaseResponse<TokenResponse> generateToken(@RequestBody TokenRequest tokenRequest){
		return tokenService.generateToken(tokenRequest);
	}
	
	
	@GetMapping("/api/v1/listToken")
	public BaseResponse<List<Token>> listToken(){
		return tokenService.listToken();
	}
	
	@PostMapping("/api/v1/updateTokenStatus")
	public BaseResponse<TokenStatusUpdateResponse> updateTokenStatus(@RequestBody TokenStatusUpdateRequest tokenStatusUpdateRequest){
		return tokenService.updateToken(tokenStatusUpdateRequest);
	}
}
