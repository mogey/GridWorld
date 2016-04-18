/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */
package com.mogey.gridworld.marques;
import com.mogey.gridworld.marques.CYO.Boss;
import com.mogey.gridworld.marques.CYO.Player;
import com.mogey.gridworld.marques.FlowerGame.FlowerCritter;
import info.gridworld.actor.*;
import info.gridworld.grid.AbstractGrid;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Location;

import java.awt.*;
import java.util.LinkedList;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class Main
{
    public static void main(String[] args){

        ActorWorld world = new ActorWorld();/*
        world.add(new Location(3,1),new Player());
        world.add(new Location(3,5), new Boss());
        world.setMessage("Type commands into the console to play, click step and do not use run.");
        System.out.print("\f");*/
        world.add(new Location(0,0), new FlowerCritter(world));
        for(int i = 0; i <= 25; i++){
            world.add(new Rock());
        }
        for(int i = 0; i < 6; i++){
            world.add(new Bug());
        }
        world.show();

    }
}