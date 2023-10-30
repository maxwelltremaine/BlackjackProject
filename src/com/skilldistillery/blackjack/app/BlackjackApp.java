package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackApp {

	public static void main(String[] args) {

		BlackjackApp app = new BlackjackApp();
		app.run();
	}

	public void run() {
		Scanner playerIntake = new Scanner(System.in);
		Dealer benny = new Dealer();
		Player courier6 = new Player();
		benny.deal(benny, courier6);
		showHand(courier6, benny, false);

		if (courier6.getHand().isBlackJack()) {
			System.out.println("What in the gottdamn?! 21 baby? you win!");
		} else if (benny.getHand().isBlackJack()) {
			System.out.println("From where you're sitting it must seem like an 18-carat run of bad luck. Truth is...the game was rigged from the start");
			System.out.println("Dealer Wins");
		} else {
			playTurns(courier6, benny, playerIntake);
		}
	}

	public void menu() {
		System.out.println("=============");
		System.out.println("Press 1 to hit");
		System.out.println("Press 2 to stay");
		System.out.println("=============");
	}

	public void playTurns(Player courier6, Dealer benny, Scanner playerIntake) {
		boolean bennysTurn = false;
		Player winner = null;

		while (winner == null) {
			if (!bennysTurn) {
				menu();
				int hitOrStay = playerIntake.nextInt();
				playerIntake.nextLine();

				if (hitOrStay == 1) {
					benny.hit(courier6.getHand());
					showHand(courier6, benny, bennysTurn);
					winner = checkWinner(courier6, benny, bennysTurn);
				} else if (hitOrStay == 2) {
					bennysTurn = true;
					showHand(courier6, benny, bennysTurn);
				} else {
					System.out.println("Invalid input");
				}
			} else {
				if (benny.getHand().getHandValue(bennysTurn) < 17) {
					benny.hit(benny.getHand());
					showHand(courier6, benny, bennysTurn);
				} else {
					winner = checkWinner(courier6, benny, bennysTurn);
				}
			}
		}
		if (winner instanceof Dealer) {
			System.out.println("ringa ding ding baby, house always wins");
		}
		else if (winner instanceof Player) {
			System.out.println("Well well well, looks like you got yourself a win, ain't that a kick in the head!");
		}
		else {
			System.out.println("its a draw!");
		}
	}

	public void showHand(Player player, Dealer dealer, boolean isDealerTurn) {
		if (!isDealerTurn) {
			System.out.println(
					"Courier 6's " + player.getHand().toString() + " Total = " + player.getHand().getHandValue(true));
			System.out.println("Benny's " + dealer.getHand().getHandValue(isDealerTurn));
			System.out.println();
		} else {
			System.out.println(
					"Courier 6's " + player.getHand().toString() + " Total = " + player.getHand().getHandValue(true));
			System.out.println("Benny's " + dealer.getHand().toString() + " Total = "
					+ dealer.getHand().getHandValue(isDealerTurn));
			System.out.println();
		}
	}

	public Player checkWinner(Player player, Dealer dealer, boolean dealersTurn) {
		if (dealersTurn) {
			if (dealer.getHand().isBust()) {
				return player;
			} else if (dealer.getHand().isBlackJack()) {
				return dealer;
			} else if (player.getHand().getHandValue(true) > dealer.getHand().getHandValue(true)) {
				return player;
			} else if (dealer.getHand().getHandValue(true) > player.getHand().getHandValue(true)) {
				return dealer;
			} else {
				return null;
			}
		} else {
			if (player.getHand().isBust()) {
				return dealer;
			} else if (player.getHand().isBlackJack()) {
				return player;
			}
		}
		return null;
	}
}

//scanner belongs only here
