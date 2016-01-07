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
public class BattleBug extends Bug{
    private ArrayList<Location> occupiedLocations;
    private Grid<Actor> gr;
    public BattleBug(){

    }
    public void act(){
        gr = getGrid();
        occupiedLocations = gr.getOccupiedAdjacentLocations(getLocation());
        for(Location i : occupiedLocations){
            if(gr.get(i) instanceof Bug){
                Random rnd = new Random();
                if(rnd.nextInt(10) >= 5){
                    gr.get(i).removeSelfFromGrid();
                    System.out.print("Dead");
                    moveTo(i);
                }
            }
        }
        move();
    }
}
