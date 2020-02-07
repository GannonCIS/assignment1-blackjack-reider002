/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author gubotdev
 */
public class Dealer {

    //in-class work
    private Player[] myPlayers;
    private Deck myDeck = new Deck();
    private Scanner scan = new Scanner(System.in);

    public Dealer(int numOfPlayers) {

        initMyPlayers(numOfPlayers);
        //passing it through, the initMyPlayers only one that has a value

    }

    //my work (assigned homework)
    //private int handValue = 0;
    //private int winner = 0;
    private Hand dealerHand = new Hand();
    //dealer needs his own hand

    public void dealOpeningHands() {
        for (int i = 0; i < 2; i++) {
            for (Player currPlayer : myPlayers) {
                //for : each loop
                //organic idorator for java - sticking ino another varibale
                currPlayer.getMyHand().addCard(myDeck.dealCard());
            }
            dealerHand.addCard(myDeck.dealCard());
            //not printing out hand at this point
            //all this fufills our model 

        }

    }

    public void takePlayerTurns(Deck deck) {
        for(Player currPlayer : myPlayers){
            while(currPlayer.getMyHand().getNumOfCards() < 5 &&
                    currPlayer.getMyHand().getScore() < 21){
                    //we have 2 conditions
                    //"this players turn is oer, time to go to the next player
                System.out.println(currPlayer.getName() + " 's Hand");
                currPlayer.getMyHand().printHand();
                System.out.println("Wanna hit? (y/n)");
                char opt = scan.next().charAt(0);
                if(opt=='y'){
                    currPlayer.getMyHand().addCard(myDeck.dealCard());
                }
            }
            currPlayer.getMyHand().printHand();
            //just to make sure the player sses it
        }
    }

    public void playOutDealerHand() {
        while(dealerHand.getScore()>16){
            dealerHand.addCard(myDeck.dealCard());
        }
        dealerHand.printHand();
        //print dealer hand
        //if statement to see if dealer has more points than player

    }

    public void declareWinner() {
        //can check if dealer busted?

    }

    //from classwork
    private void initMyPlayers(int numOfPlayers) {

        myPlayers = new Player[numOfPlayers];
        for (int i = 0; i < myPlayers.length; i++) {
            //sout + tab gives:
            System.out.println("Player " + (i + 1) + "what's your name:");
            //don'd want to incatinate with the plus sign, so we put i+1 in ()
            String name = scan.next();
            if (name.equals("")) {
                //just in case player gives an empty string (inputs nothing)
                myPlayers[i] = new Player(i + 1);
            } else {
                myPlayers[i] = new Player(name);
                //incatinating the playerNum from player class
            }
        }
    }
}
