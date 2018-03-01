package org.test.boot.http.model;

import org.test.boot.dao.model.Operator;
import org.test.boot.dao.model.Token;
import org.test.boot.dao.model.TokenStatus;

public class TokenStatusUpdateRequest {

	Token token;
	Operator operator;
	
	TokenStatus tokenStatus;
	
	public TokenStatus getTokenStatus() {
		return tokenStatus;
	}
	public void setTokenStatus(TokenStatus tokenStatus) {
		this.tokenStatus = tokenStatus;
	}
	public Token getToken() {
		return token;
	}
	public void setToken(Token token) {
		this.token = token;
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
}
