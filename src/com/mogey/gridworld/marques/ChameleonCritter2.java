package com.mogey.gridworld.marques;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;

import java.util.ArrayList;

/**
 * Copyright Mohsin created on 1/19/2016 for bugs
 * com.bugs.gridworld.mogey
 */
public class ChameleonCritter2 extends Critter {
    @Override
    public void processActors(ArrayList<Actor> actors){
        for (Actor a : actors)
        {if(a instanceof Actor) {
            if (!(a instanceof Rock) && !(a instanceof Critter))
                setColor(a.getColor());
        }
        }
        setColor(getColor().darker());
    }
}
