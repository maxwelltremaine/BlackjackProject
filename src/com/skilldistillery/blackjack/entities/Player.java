package com.skilldistillery.blackjack.entities;

public class Player {
	private BlackjackHand hand;
	
	public Player(){
		hand = new BlackjackHand();
	}
	public BlackjackHand getHand() {
		return hand;
	}
	
}
