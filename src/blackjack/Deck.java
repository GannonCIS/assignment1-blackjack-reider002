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
public class Deck {

    private Card[] myCards = new Card[52];
    //needs a constructor to be called - new keyword to initialize here
    private String[] ranks = {};
    private String[] suits = {};
    private int nextCard = 0;

    public Deck() {

    }

    private void initDeck() {

    }

    private void shuffle() {

    }

    //print deck is for testing only - delete me later
    public void printDeck() {

    }

    public Card dealCard() {
        return null;
        //returning null so you don't error - do not forget to change this
    }
}
