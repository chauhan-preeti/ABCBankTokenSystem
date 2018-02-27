package org.test.boot.http.cache;

import java.util.Queue;

import org.test.boot.dao.model.Token;
import org.test.boot.dao.model.TokenType;

public class TokenCache {
	private TokenType tokenType;
	private Queue<Token> tokenQueue;
	public TokenType getTokenType() {
		return tokenType;
	}
	public void setTokenType(TokenType tokenType) {
		this.tokenType = tokenType;
	}
	public Queue<Token> getTokenQueue() {
		return tokenQueue;
	}
	public void setTokenQueue(Queue<Token> tokenQueue) {
		this.tokenQueue = tokenQueue;
	}
}
