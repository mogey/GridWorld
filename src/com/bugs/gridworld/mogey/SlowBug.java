package com.bugs.gridworld.mogey;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;

import static java.awt.Color.GREEN;

public class SlowBug extends Bug {
    private int _counter = 0;
    //Constructors
    public SlowBug(){
        setColor(GREEN);
    }
    public SlowBug(Color color){
        setColor(color);
    }

    @Override
    public void move(){
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
        Rock rocky = new Rock(getColor());
        rocky.putSelfInGrid(gr, loc);


    }


    public void act(){
        if(_counter > 3){
            _counter = 0;
            if(canMove()){
                move();
            }else{
                turn();
            }

        }
        _counter++;
    }

}
