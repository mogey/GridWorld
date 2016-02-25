package com.mogey.gridworld.marques;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;

import java.util.ArrayList;

/**
 * Copyright Mohsin created on 2/4/2016 for bugs
 * com.bugs.gridworld.mogey
 */
public class BullyChameleonCritter extends ChameleonCritter2 {
    @Override
    public void processActors(ArrayList<Actor> actors){
        for (Actor a : actors)
        {
            a.setColor(getColor());
        }
    }
}
