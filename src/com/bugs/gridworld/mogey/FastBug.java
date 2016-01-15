package com.bugs.gridworld.mogey;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.Random;

/**
 * Copyright Mohsin created on 1/14/2016 for bugs
 * com.bugs.gridworld.mogey
 */
public class FastBug extends Bug {
    Random rnd = new Random();
    public FastBug(){
        setColor(Color.red);
        setDirection(rnd.nextInt(366));
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
        Flower flower = new Flower(getColor().darker().darker().darker().darker().darker());
        flower.putSelfInGrid(gr, loc);


    }
    public void act(){
        if(canMove()){
            move();
            if(canMove()){ move();}else{turn();}
        }else{
            turn();
            if(canMove()){ move();}else{turn();}
        }
    }
}
