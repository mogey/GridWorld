package com.mogey.gridworld.marques;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
/**
 * Copyright aster69 created on 3/24/2016 for GridWorld-master
 * com.mogey.gridworld.marques
 */
public class GuiFindBug extends Bug {
    Location loc = new Location(2,4);
    public GuiFindBug()
    {


    }


    public void act(){
       Grid<Actor> gr = getGrid();
        Location myLoc = this.getLocation();

        this.setDirection(myLoc.getDirectionToward(loc));

        if(canMove())
            move();

    }
}


