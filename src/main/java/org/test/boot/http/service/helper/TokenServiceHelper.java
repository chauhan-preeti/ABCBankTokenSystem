package org.test.boot.http.service.helper;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.test.boot.dao.model.Customer;
import org.test.boot.dao.model.CustomerType;
import org.test.boot.dao.model.Token;
import org.test.boot.dao.model.TokenStatus;
import org.test.boot.dao.model.TokenType;
import org.test.boot.dao.repos.CustomerRepository;
import org.test.boot.dao.repos.TokenRepository;
import org.test.boot.http.cache.TokenCacheProvider;
import org.test.boot.http.model.TokenRequest;
import org.springframework.web.client.RestTemplate;

@Component
public class TokenServiceHelper {
	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private CustomerRepository customerRepository;

	public Token generateNewToken(TokenRequest tokenRequest) {
		Customer customer = customerRepository.findByCustomerMobile(tokenRequest.getMobileNumber());
		Token token = new Token();
		if (customer == null) {
			RestTemplate restTemplate = new RestTemplate();
		} else {
			token.setIssueDate(new Date());
			token.setTokenStatus(TokenStatus.NEW);
			token.setTokenType(getTokenTypeForCustomer(customer));
		}
		tokenRepository.save(token);
		TokenCacheProvider.publishToken(token);

		return token;
	}

	private TokenType getTokenTypeForCustomer(Customer customer) {
		TokenType tokenType = null;
		if (customer == null) {
			tokenType = TokenType.NEW;
			// return tokenType;
		} else if (CustomerType.NORMAL.equals(customer.getCustomerType())) {
			tokenType = TokenType.NORMAL;
		} else if (CustomerType.PREVILIDGED.equals(customer.getCustomerType())) {
			tokenType = TokenType.PRIVILAGED;
		}

		return tokenType;

	}

	public List<Token> listToken() {
		return tokenRepository.findAll();
	}
}
