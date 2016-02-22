package com.mogey.gridworld.marques;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Copyright Mohsin created on 2/10/2016 for bugs
 * com.mogey.gridworld.marques
 */
public class EdgesChameleonCritter extends ChameleonCritter2{
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        //rows
        for(int i = 0; i != getGrid().getNumCols(); i++){
            if ((getGrid().get(new Location(0,i)) instanceof Actor))
                actors.add(getGrid().get(new Location(0, i)));
            if ((getGrid().get(new Location(getGrid().getNumRows(),i))) instanceof Actor);
                actors.add(getGrid().get(new Location(getGrid().getNumRows(),i)));

        }
        //cols
        for(int i = 0; i != getGrid().getNumRows(); i++){
            if ((getGrid().get(new Location(i,0)) instanceof Actor))
                actors.add(getGrid().get(new Location(i,0)));
            if((getGrid().get(new Location(i,getGrid().getNumCols()))) instanceof Actor)
                actors.add(getGrid().get(new Location(i,getGrid().getNumCols())));
        }
        return actors;

    }
}
