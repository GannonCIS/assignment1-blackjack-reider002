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
public class Hand {

    private Card[] myCards = new Card[5];
    private int numOfCards = 0;
    private int score = 0;

    public Hand() {
    }
    //constructor - default

    public int getNumOfCards() {
        return numOfCards;
    }

    public int getScore() {
        return score;
    }

    public void addCard(Card newCard) {
        if (numOfCards > 4) {
            System.out.println("Too many cards for this hand");
            //not catching that error is sloppy - fatal error
            //only programmers will see this error messag tho
        } else {
            myCards[numOfCards] = newCard;
            numOfCards++;
            //going to keep track of score but not "bust" - dealers job
            try{score += Integer.parseInt(newCard.RANK);
                //just saying "expect this number"
                //need the exception to do the try-catch
                //is a primitive typically, but int class will do things
            } catch (java.lang.NumberFormatException ex) {
                if (newCard.RANK.equals("Ace")) {
                    score += 1;
                } else {
                    score += 10;
                }
            }
        }

    }

    public void printHand() {
        for (int i = 0; i < numOfCards; i++) {
            System.out.println(myCards[i].RANK + " of " + myCards[i].SUIT);
            //copied from deck method printDeck
            //player needs to see their hand
        }
    }
}
