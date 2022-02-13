package pt.utad.egonh.euromilregister.grpcEuroMilRegister.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Bet {
	
	@JsonProperty("key")
	String keyGame;
	@JsonProperty("checkid")
	String checkId;
	public Bet() {
		super();
	}
	public Bet(String keyGame, String checkId) {
		super();
		this.keyGame = keyGame;
		this.checkId = checkId;
	}
	public String getKeyGame() {
		return keyGame;
	}
	public void setKeyGame(String keyGame) {
		this.keyGame = keyGame;
	}
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}
	@Override
	public String toString() {
		return "Bet [keyGame=" + keyGame + ", checkId=" + checkId + "]";
	}
}
