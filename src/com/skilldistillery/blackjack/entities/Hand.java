package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
// not everything but some
	protected List<Card> cards;

	public Hand() {
		cards = new ArrayList<>();
	}
	public void addCard(Card card) {
		cards.add(card);
	}
	public void clear() {
		cards.clear();
	}
	public abstract int getHandValue(boolean isTurn);
	@Override
	public String toString() {
		return "hand contains " + cards;
	}
	
	
	

}
