package org.test.boot.http.model;

import org.test.boot.dao.model.Token;

public class TokenStatusUpdateResponse {
	
	Token token;

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

}
