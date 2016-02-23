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

        int x = getLocation().getCol();
        int y = getLocation().getRow();
        while(x != 0 && y != 0){
            x--;
            y--;
            Location n = new Location(y,x);
            if(getGrid().get(n) instanceof Actor){
                actors.add(getGrid().get(n));
            }
        }
        x = getLocation().getCol();
        y = getLocation().getRow();
        while(x != 0 && y != getGrid().getNumRows()){
            x--;
            y++;
            Location n = new Location(y,x);
            if(getGrid().get(n) instanceof Actor){
                actors.add(getGrid().get(n));
            }
        }
        x = getLocation().getCol();
        y = getLocation().getRow();
        while(x != getGrid().getNumCols() && y != getGrid().getNumRows()){
            x++;
            y++;
            Location n = new Location(y,x);
            if(getGrid().get(n) instanceof Actor){
                actors.add(getGrid().get(n));
            }
        }
        x = getLocation().getCol();
        y = getLocation().getRow();
        while(x != getGrid().getNumCols() && y != 0){
            x++;
            y--;
            Location n = new Location(y,x);
            if(getGrid().get(n) instanceof Actor){
                actors.add(getGrid().get(n));
            }
        }


        return actors;

    }
}
