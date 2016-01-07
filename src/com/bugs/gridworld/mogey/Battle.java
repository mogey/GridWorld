package com.bugs.gridworld.mogey;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * Created by Mohsin on 1/7/2016.
 */
public class Battle {
    FightBug a;
    FightBug b;
    Grid<Actor> gr;
    public Battle(){
        throw new IllegalStateException("Battle is missing bugs");
    }
    public Battle(Bug a, Bug b){
        a = a;
        b = b;
        gr = a.getGrid();
        fight();
    }
    public void fight(){
        if(b.getRoll() > a.getRoll()){
            Location loc = a.getLocation();
            b.moveTo(loc);
        }
        else{
            Location loc = b.getLocation();
            a.moveTo(loc);
        }
    }
}
