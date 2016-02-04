package com.mogey.gridworld.marques;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Created by Mohsin on 1/6/2016.
 */
public class FlowerBug extends Bug{
    Grid<Actor> gr;
    ArrayList<Location> occupiedLocations;
    public FlowerBug(){
    }
    public void act(){
        gr = getGrid();
        occupiedLocations = gr.getOccupiedLocations();
        for(Location i : occupiedLocations){
            if(gr.get(i) instanceof Rock){
                moveTo(i);
                super.move();
                Flower flower = new Flower(gr.get(i).getColor());
                flower.putSelfInGrid(gr,i);
            }
        }
    }
}
