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
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9",
          "10", "Jack", "Queen", "King"};

    private String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    private int nextCard = 0;

    public Deck() {
        initDeck();
        shuffle();
        
    }

    private void initDeck() {
        int index = 0;
        //example
        for (int s = 0; s < suits.length; s++) {
            for (int r = 0; r < ranks.length; r++) {
                myCards[index] = new Card(ranks[r], suits[s]);
                //never need to reference - just asking for index
                index++;
            }
        }
    }

    private void shuffle() {
        for(int i=0;i<myCards.length;i++){
            Card temp = myCards[i];
            int rand = (int)(Math.random()*52);
            myCards[i] = myCards[rand];
            //here you have 2 copies of a card
            myCards[rand] = temp;
            //solves duplicate card
            
            
        }
    }

    //print deck is for testing only - delete me later
    public void printDeck() {
        for (int i = 0; i < myCards.length; i++) {
            System.out.println(myCards[i].RANK + " of " + myCards[i].SUIT);
            //card objcts
        }
    }

    public Card dealCard() {
        return null;
        //returning null so you don't error - do not forget to change this
    }
}
