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
public class Player {

    private Hand myHand = new Hand();
    private String name;

    //overloading this method to help with player name issues
    public Player(String name) {
        this.name = name;
    }

    public Player(int playerNum) {
        name = "player " + playerNum;
        //this is polymorphism, not using the "this" keywork
    }

    public Hand getMyHand() {
        return myHand;
        //putting this here so avoid confusion of ownership of hands for each
        //player
    }

    public String getName() {
        return name;
    }
}
