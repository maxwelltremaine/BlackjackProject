package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;

	public Deck() {
		deck = new ArrayList<>();


		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();

		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card aCard = new Card(suit, rank);
				deck.add(aCard);
			}
		}
	}

	public int checkDeckSize() {
		return deck.size();
	}

	public Card dealCard() {
		Card randomCard = null;
		randomCard = deck.remove(0);
		return randomCard;
	}
	public void dealCard(Hand playerHand) {
		playerHand.addCard(dealCard());
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	



}
