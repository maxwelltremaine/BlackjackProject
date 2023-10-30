package com.skilldistillery.blackjack.entities;

public class BlackjackHand extends Hand {

	public BlackjackHand() {
		super();
	}

	@Override
	public int getHandValue(boolean isTurn) {
		int totalValue = 0;
		if (isTurn) {
			for (int i = 0; i < cards.size(); i++) {
				totalValue += cards.get(i).getRank().getValue();
			}
		}else {
			totalValue = cards.get(1).getRank().getValue();
		}
		return totalValue;

	}

	public boolean isBlackJack() {
		return getHandValue(true) == 21;
	}

	public boolean isBust() {
		return getHandValue(true) > 21;
	}

}
