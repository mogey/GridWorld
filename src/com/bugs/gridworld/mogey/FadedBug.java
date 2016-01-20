package com.bugs.gridworld.mogey;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import javafx.scene.paint.Color;

import java.util.ArrayList;

/**
 * Copyright Mohsin created on 1/20/2016 for bugs
 * com.bugs.gridworld.mogey
 */
public class FadedBug extends FastBug{
    ArrayList<Location> occupiedLocations;
    private Grid<Actor> gr;
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Flower flower = new Flower(getColor());
        flower.putSelfInGrid(gr, loc);
    }
    @Override
    public void act(){
        gr = getGrid();
        occupiedLocations = gr.getOccupiedAdjacentLocations(getLocation());
        setDirection(rnd.nextInt(366));
        for(Location i : occupiedLocations){
            setColor(gr.get(i).getColor());
        }
        if(canMove()){
            move();
            if(canMove()){ move();}else{turn();}
        }else{
            turn();
            if(canMove()){ move();}else{turn();}
        }
    }
}
