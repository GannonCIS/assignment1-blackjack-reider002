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

    public void playGame() {
        dealOpeningHands();
        takePlayerTurns();
        playOutDealerHand();
        declareWinner();
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

    public void takePlayerTurns() {
        for (Player currPlayer : myPlayers) {
            while (currPlayer.getMyHand().getNumOfCards() < 5
                    && currPlayer.getMyHand().getScore() < 21) {
                //we have 2 conditions
                //"this players turn is oer, time to go to the next player
         
                System.out.println(currPlayer.getName() + "'s Hand");
                currPlayer.getMyHand().printHand();
                System.out.println("Player score: " + currPlayer.getMyHand().getScore());
                
                System.out.println("Dealer's hand: ");
                dealerHand.printHand();
                System.out.println("Dealer score: " + dealerHand.getScore());
                
                System.out.println("Wanna hit? (y/n)");
                char opt = scan.next().charAt(0);
                if (opt == 'y') {
                    currPlayer.getMyHand().addCard(myDeck.dealCard());
                } else {
                    break;
                }
            }
            currPlayer.getMyHand().printHand();
            //just to make sure the player sses it
        }
    }

    public void playOutDealerHand() {
        while (dealerHand.getScore() > 21) {
            dealerHand.addCard(myDeck.dealCard());
        }
        dealerHand.printHand();
        //print dealer hand
        //if statement to see if dealer has more points than player

    }

    public void declareWinner() {

        //Lab 2/10/2020
        System.out.println("Dealer's hand: ");
        dealerHand.printHand();
        System.out.println("Dealer score: " + dealerHand.getScore());
        
        for (int i = 0; i < myPlayers.length; i++) {
            Player currPlayer = myPlayers[i];
            System.out.println(currPlayer.getName() + "'s hand");
            if (dealerHand.getScore() > 21
                    || currPlayer.getMyHand().getScore() > 21) {
                if (currPlayer.getMyHand().getScore() > 21) {
                    System.out.println(currPlayer.getName() + " you busted");
                } else {
                    System.out.println(currPlayer.getName() + " dealer busted!"
                            + " You win! ");
                }
            } else if (dealerHand.getScore() == 21
                    || dealerHand.getNumOfCards() > 4) {
                System.out.println(currPlayer.getName() + "you loose");

            } else if (currPlayer.getMyHand().getNumOfCards() > 4) {
                System.out.println(currPlayer.getName()
                        + "5 cards under" + " You win");
            } else if (currPlayer.getMyHand().getScore()
                    > dealerHand.getScore()) {
                System.out.println(currPlayer.getName() + " you win");
            } else {
                System.out.println(currPlayer.getName()
                        + "quit now while you can");
            }
        }
    }

    //at home work
    /* if (dealerHand.getScore() > 21) {
            System.out.println("Dealer busts!");
            //for when dealer busts

            if (dealerHand.getScore() == 21 || dealerHand.getNumOfCards() > 4) {
                System.out.println("Dealer wins");
            }
        }
        for (Player currPlayer : myPlayers) {
            if (currPlayer.getMyHand().getScore() > 21) {
                System.out.println(currPlayer + " has busted!");
            } else if (currPlayer.getMyHand().getNumOfCards() == 5
                    && (dealerHand.getScore() < 21
                    || dealerHand.getNumOfCards() < 5)) {
                System.out.println(currPlayer + " has won!");
                //when player’s score is < 22 but > the dealers score and
                //dealer has less than 5 cards
            } else if (currPlayer.getMyHand().getScore()
                    == dealerHand.getScore()) {
                System.out.println("Tie! Dealer Wins!");
                //in case of tie
            }
            if(currPlayer.getMyHand().getScore()<22){
                System.out.println(currPlayer + "wins!");
            }*/
//from classwork
    private void initMyPlayers(int numOfPlayers) {

        myPlayers = new Player[numOfPlayers];
        for (int i = 0; i < myPlayers.length; i++) {
            //sout + tab gives:
            System.out.println("Player " + (i + 1) + " what's your name:");
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
