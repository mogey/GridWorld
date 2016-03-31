package com.mogey.gridworld.marques.CYO;

import info.gridworld.actor.Actor;

/**
 * Created by mqureshi16 on 3/15/2016.
 */
public class Attack extends Actor{
    public int damage = 2;
    public int chance = 2;
    private int turn = 0;
    public Attack() {
        setColor(null);
    }

    public void act(){
        System.out.println("\nSTEPPED\n");
        System.out.println(this.getClass()+" timed out and was removed.");
        removeSelfFromGrid();
    }
}
