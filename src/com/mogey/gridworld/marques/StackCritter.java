package com.mogey.gridworld.marques;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Copyright Mohsin created on 2/22/2016 for bugs
 * com.mogey.gridworld.marques
 */
public class StackCritter extends ChameleonCritter2{
    private Stack<Actor> actorStack = new Stack<Actor>();
    public void processActors(ArrayList<Actor> actors)
    {
        for (Actor a : actors)
        {
            actorStack.push(a);
            a.removeSelfFromGrid();
        }
    }
    public void makeMove(Location loc)
    {
        if (loc == null)
            removeSelfFromGrid();
        else
            moveTo(loc);

        System.out.println(actorStack);
    }
}
