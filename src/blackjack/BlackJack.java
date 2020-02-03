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
public class BlackJack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Deck myDeck = new Deck();
        Hand myHand = new Hand();
        
        
        for(int i=0;i<6;i++){
            myHand.addCard(myDeck.dealCard());
            
            System.out.println("numOfCards" + myHand.getNumOfCards() + "|" 
                    + "score" + myHand.getScore());
            //i<6 - want to see the error
           //Card temp = myDeck.dealCard();
           //capturing card it returns (refrence to a card)
            //System.out.println(temp.RANK + " of " + temp.SUIT);
        }
    }
    
}
