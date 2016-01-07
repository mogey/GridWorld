package com.bugs.gridworld.mogey;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

import java.util.*;
/**
 * Created by Mohsin on 1/5/2016.
 */
public class NSEWBug extends Bug{
    private Random rnd = new Random();
    public NSEWBug(){

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
    public void act(){
        if(canMove()) {
            turn();
            super.move();
        }
        else
            turn();
    }
}
