package com.bugs.gridworld.mogey;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

import java.util.ArrayList;

/**
 * Copyright Mohsin created on 1/19/2016 for bugs
 * com.bugs.gridworld.mogey
 */
public class ChameleonCritter extends Critter {
    @Override
    public void processActors(ArrayList<Actor> actors){
        for (Actor a : actors)
        {
            if (!(a instanceof Rock) && !(a instanceof Critter))
                setColor(a.getColor());
        }
        setColor(getColor().darker());
    }
}
