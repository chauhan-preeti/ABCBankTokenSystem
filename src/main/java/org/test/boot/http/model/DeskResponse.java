package org.test.boot.http.model;

import java.util.List;

import org.test.boot.dao.model.Token;

public class DeskResponse {
	private String name;
	private List<Token> waitingList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Token> getWaitingList() {
		return waitingList;
	}
	public void setWaitingList(List<Token> waitingList) {
		this.waitingList = waitingList;
	}
}
