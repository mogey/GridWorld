package com.mogey.gridworld.marques;

import com.sun.jmx.remote.internal.ArrayQueue;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Copyright Mohsin created on 2/22/2016 for bugs
 * com.mogey.gridworld.marques
 */
public class QueueCritter extends ChameleonCritter2{
    private ArrayQueue<Actor> actorQueue = new ArrayQueue<Actor>(8);
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            actorQueue.add(a);
            a.removeSelfFromGrid();
        }
    }
    public void makeMove(Location loc)
    {
        if (loc == null)
            removeSelfFromGrid();
        else
            moveTo(loc);

        System.out.println(actorQueue);
    }
}
