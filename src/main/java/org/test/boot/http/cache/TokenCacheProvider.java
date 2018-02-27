package org.test.boot.http.cache;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.boot.dao.model.Token;
import org.test.boot.dao.model.TokenType;
import org.test.boot.dao.repos.TokenRepository;

@Component
public class TokenCacheProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(TokenCacheProvider.class);
	@Autowired
	private TokenRepository tokenRepository;
	
	private static Map<TokenType, TokenCache> tokenCacheMap = new java.util.concurrent.ConcurrentHashMap<TokenType, TokenCache>();
	
	public static Queue<Token> fetchTokenList(TokenType tokenType) {
		return tokenCacheMap.get(tokenType).getTokenQueue();
	}
	
	public static boolean publishToken(Token token) {
		return tokenCacheMap.get(token.getTokenType()).getTokenQueue().add(token);
	}
	
	
	@PostConstruct
	public void loadCache() {
		for(TokenType tokenType : TokenType.values()) {
			List<Token> list = tokenRepository.findAllByTokenType(tokenType);
			TokenCache tokenCache =new TokenCache();
			tokenCache.setTokenType(tokenType);
			tokenCache.setTokenQueue(new LinkedList<Token>());
			tokenCacheMap.put(tokenType, tokenCache);
			if(list != null) {
				tokenCache.getTokenQueue().addAll(list);
			}
			logger.info("Token Type :{}, current List : {}", tokenType, tokenCache.getTokenQueue().size() );
			
			
			
		}
	}
	
	@PreDestroy
	public void cleanUp() {
		if( tokenCacheMap != null) {
			tokenCacheMap.entrySet().forEach(e -> {
				e.getValue().getTokenQueue().clear();
			});
			tokenCacheMap.clear();
			tokenCacheMap =null;
		}
	}
}
