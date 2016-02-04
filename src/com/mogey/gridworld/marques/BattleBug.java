package com.mogey.gridworld.marques;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class BattleBug extends Bug{
    private ArrayList<Location> occupiedLocations;
    private Grid<Actor> gr;
    public BattleBug(){}
    Random rnd = new Random();
    public BattleBug(Color color) {
        setColor(color);
    }

    public void act(){
        gr = getGrid();
        occupiedLocations = gr.getOccupiedAdjacentLocations(getLocation());
        for(Location i : occupiedLocations){
            if(gr.get(i) instanceof Bug){
                Random rnd = new Random();
                if(rnd.nextInt(10) >= 5){
                    gr.get(i).removeSelfFromGrid();
                    System.out.println("Dead");
                    moveTo(i);
                }
            }
        }
        if(canMove()){
            turn();
            move();
        }
        else
            turn();

    }
    public void turn(){
        switch (rnd.nextInt(4)) {
            case 0:
                setDirection(Location.NORTH);
                break;
            case 1:
                setDirection(Location.EAST);
                break;
            case 2:
                setDirection(Location.SOUTH);
                break;
            case 3:
                setDirection(Location.WEST);
                break;
        }
    }
}
