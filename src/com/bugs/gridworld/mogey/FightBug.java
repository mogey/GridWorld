package com.bugs.gridworld.mogey;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mohsin on 1/7/2016.
 */
public class FightBug extends Bug {
    Random rnd = new Random();
    int roll = rnd.nextInt(10);
    ArrayList<Location> occupiedLocations;
    Grid<Actor> gr;
    public FightBug(){
        roll = rnd.nextInt(11);
    }
    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }
    public void act(){
        gr = getGrid();
        occupiedLocations = gr.getOccupiedAdjacentLocations(getLocation());
        for(Location i : occupiedLocations){
            if(gr.get(i) instanceof FightBug){
                Battle battle = new Battle((FightBug)gr.get(i),this);
                battle.fight();
            }
            move();
        }
        move();
    }
}
