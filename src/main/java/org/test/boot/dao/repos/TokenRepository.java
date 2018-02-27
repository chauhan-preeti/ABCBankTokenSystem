package org.test.boot.dao.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.test.boot.dao.model.Token;
import org.test.boot.dao.model.TokenStatus;
import org.test.boot.dao.model.TokenType;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
	public List<Token> findByTokenTypeAndTokenStatus(TokenType tokenType, TokenStatus tokenStatus);
	
	@Query("FROM org.test.boot.dao.model.Token where tokenType = ?1 and tokenStatus != 'COMPLETED'")
	public List<Token> findAllByTokenType(@Param(value = "tokenType") TokenType tokenType);
}
