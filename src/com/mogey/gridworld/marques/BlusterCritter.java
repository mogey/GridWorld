package com.mogey.gridworld.marques;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;

/**
 * Copyright Mohsin created on 1/19/2016 for bugs
 * com.bugs.gridworld.mogey
 */
public class BlusterCritter extends Critter{
    ArrayList<Location> neighbors;
    private int c=0;
    private Grid<Actor> gr;
    public BlusterCritter(int courage){
        c = courage;
        setColor(Color.pink);
    }
    @Override
    public void act(){
        //Doesn't check 2 over, only 1
        gr = getGrid();
        neighbors = gr.getOccupiedAdjacentLocations(getLocation());
        int critCount = 0;
        for(Location i : neighbors){
            if(gr.get(i) instanceof Critter){
                critCount++;
            }
        }
        if(critCount > c){
            setColor(getColor().darker().darker().darker());
        }else{
            setColor(getColor().brighter().brighter().brighter());
        }

        if(this.getGrid() != null) {
            ArrayList actors = this.getActors();
            this.processActors(actors);
            ArrayList moveLocs = this.getMoveLocations();
            Location loc = this.selectMoveLocation(moveLocs);
            this.makeMove(loc);
        }

    }
}
