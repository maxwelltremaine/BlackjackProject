package com.skilldistillery.blackjack.entities;

import java.util.List;

public abstract class Hand {
// not everything but some
	protected List<Card> cards;
	
	
	public abstract int getHandValue();
	
	
}
