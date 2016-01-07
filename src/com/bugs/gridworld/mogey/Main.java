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
package com.bugs.gridworld.mogey;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.awt.Color;

/**
 * This class runs a world that contains box bugs. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class Main
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        Rock rocky = new Rock();
        NSEWBug nsew = new NSEWBug();
        world.add(nsew);
        FlowerBug bab = new FlowerBug();
        world.add(new Location(7,9), rocky);
        world.add(bab);
        BattleBug a = new BattleBug();
        BattleBug b = new BattleBug();
        world.add(new Location(2,2), a);
        world.add(new Location(2,3), b);
        world.show();
    }
}