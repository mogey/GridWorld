package com.mogey.gridworld.marques.runner;

import com.mogey.gridworld.marques.CrossChameleonCritter;
import info.gridworld.actor.*;

/**
 * Copyright Mohsin created on 2/25/2016 for bugs
 * com.mogey.gridworld.marques.runner
 */
public class CrossChameleonCritterRunner
{

    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        CrossChameleonCritter d = new CrossChameleonCritter();
        Critter c1, c2, c3;
        Flower f1,f2,f3;
        Rock r1,r2,r3;
        Bug b1,b2,b3;

        c1 = new Critter(); c2 = new Critter(); c3 = new Critter();
        f1 = new Flower(); f2 = new Flower(); f3 = new Flower();
        r1 = new Rock(); r2 = new Rock(); r3 = new Rock();
        b1 = new Bug(); b2 = new Bug(); b3 = new Bug();

        world.add(d);
        world.add(c1); world.add(c2);world.add(c3);
        world.add(f1); world.add(f2);world.add(f3);
        world.add(r1); world.add(r2);world.add(r3);
        world.add(b1); world.add(b2);world.add(b3);

        world.show();

    } // main

} //  ABC_ChameleonCritter_Runner
