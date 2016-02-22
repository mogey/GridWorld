package com.mogey.gridworld.marques;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Copyright Mohsin created on 2/22/2016 for bugs
 * com.mogey.gridworld.marques
 */
public class TwoAwayChameleonCritter extends ChameleonCritter2 {
    public ArrayList<Actor> getActors()
    {
        Grid<Actor> gr = getGrid();
        ArrayList<Actor> actors = new ArrayList<Actor>();
        //top
        for(int i = -2; i != 2; i++){
            Location t = new Location(getLocation().getRow()+2,getLocation().getCol()+i);
            if(gr.isValid(t)){
                actors.add(gr.get(t));
            }
        }
        //bottom
        for(int i = -2; i != 2; i++){
            Location t = new Location(getLocation().getRow()+-2,getLocation().getCol()+i);
            if(gr.isValid(t)){
                actors.add(gr.get(t));
            }
        }
        //left
        for(int i = -2; i != 2; i++){
            Location t = new Location(getLocation().getRow()+i,getLocation().getCol()+2);
            if(gr.isValid(t)){
                actors.add(gr.get(t));
            }
        }
        for(int i = -2; i != 2; i++){
            Location t = new Location(getLocation().getRow()+i,getLocation().getCol()-2);
            if(gr.isValid(t)){
                actors.add(gr.get(t));
            }
        }
        return actors;
    }
}
