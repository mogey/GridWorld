package com.bugs.gridworld.mogey;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class WarpBug extends Bug{
    ArrayList<Location> occupiedLocations;
    private Grid<Actor> gr;
    Random rnd = new Random();
    private int warps = 0;

    public WarpBug(Color color){setColor(color);}

    public void act(){
        gr = getGrid();
        occupiedLocations = gr.getOccupiedAdjacentLocations(getLocation());
        for(Location i : occupiedLocations){
            if(gr.get(i) instanceof Critter){
                if(warps > 5){
                    removeSelfFromGrid();
                    System.out.println("Warpbug died");
                }
                warp();
            }else{
                warps = 0;
            }
        }
        if(canMove())
            move();
        else {
            setDirection(rnd.nextInt(360));
        }
    }
    private void warp(){
        Location n = new Location(rnd.nextInt(gr.getNumCols()), rnd.nextInt(gr.getNumRows()));
        while(!gr.isValid(n)){
            n = new Location(rnd.nextInt(gr.getNumCols()), rnd.nextInt(gr.getNumRows()));
        }
        moveTo(n);
        System.out.println("Warp");
        warps++;
    }
 }
