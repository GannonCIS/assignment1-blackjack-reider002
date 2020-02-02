/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author gubotdev
 */
public class Dealer {

    private int handValue = 0;
    private int winner = 0;

    private Hand dealerHand = new Hand();
    //dealer needs his own hand

    public Card dealOpeningHands() {
        return null;
        //change return type later
        //to both player and dealer?

    }

    public int takePlayerTurns(Deck deck) {
        return handValue;
        //hand value always starts at zero
        //player will need to decide what they want to do

    }

    public void playOutDealerHand() {
        //print dealer hand
        //if statement to see if dealer has more points than player

    }

    public int declareWinner() {
        return winner;

    }
}
