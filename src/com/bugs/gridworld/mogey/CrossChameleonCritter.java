package com.bugs.gridworld.mogey;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Copyright Mohsin created on 2/4/2016 for bugs
 * com.bugs.gridworld.mogey
 */
public class CrossChameleonCritter extends ChameleonCritter2 {
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        //Calc updown
        for(int i = 0; i != getGrid().getNumCols(); i++){
            if ((getGrid().get(new Location(getLocation().getRow(),i)) instanceof Actor))
                actors.add(getGrid().get(new Location(getLocation().getRow(),i)));
        }
        //Calcs left right
        for(int i = 0; i != getGrid().getNumRows(); i++){
            if ((getGrid().get(new Location(getLocation().getRow(),i)) instanceof Actor))
                actors.add(getGrid().get(new Location(i,getLocation().getCol())));
        }
        return actors;

    }
}
