package com.skilldistillery.blackjack.entities;

public class Dealer extends Player {
	private Deck deck;

	public Dealer() {
		super();
		deck = new Deck();
	}

	public Deck getDeck() {
		return deck;
	}

	public void deal(Player player1, Player player2) {
		deck.shuffle();
		System.out.println("The deck has been shuffled");
		for (int i = 0; i < 2; i++) {
			deck.dealCard(player1.getHand());
			deck.dealCard(player2.getHand());
		}
	}
	public void hit(BlackjackHand hand) {
		deck.dealCard(hand);
	}

}
//Have the dealer distrubute cards
//add one card visible but stated "face down" to the player to the players hand in the sysout use + card
//add one card not visible but noted to the dealers hand achieve this by sysout the dealer adds one card
//add another card this time stated face up to the player again + card
//add another card this time stated face up to the dealer and for the first time in the dealer sysout + card
