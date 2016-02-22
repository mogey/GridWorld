package com.mogey.gridworld.marques;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Copyright Mohsin created on 2/10/2016 for bugs
 * com.mogey.gridworld.marques
 */
public class DiagonalChameleonCritter extends ChameleonCritter2{
    public ArrayList<Actor> getActors()
    {
        ArrayList<Actor> actors = new ArrayList<Actor>();
        //Calc upleft
        if ((getGrid().get(new Location(getLocation().getRow()-1,getLocation().getCol()-1)) instanceof Actor))
            actors.add(getGrid().get(new Location(getLocation().getRow()-1,getLocation().getCol()-1)));
        //Calcs  upright
        if ((getGrid().get(new Location(getLocation().getRow()-1,getLocation().getCol()+1)) instanceof Actor))
            actors.add(getGrid().get(new Location(getLocation().getRow()-1,getLocation().getCol()+1)));
        //calcs downleft
        if ((getGrid().get(new Location(getLocation().getRow()+1,getLocation().getCol()+1)) instanceof Actor))
            actors.add(getGrid().get(new Location(getLocation().getRow()+1,getLocation().getCol()+1)));
        //calc downright
        if ((getGrid().get(new Location(getLocation().getRow()+1,getLocation().getCol()-1)) instanceof Actor))
            actors.add(getGrid().get(new Location(getLocation().getRow()+1,getLocation().getCol()-1)));
        return actors;

    }
}
