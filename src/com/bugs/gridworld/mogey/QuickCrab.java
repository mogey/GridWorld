package com.bugs.gridworld.mogey;

import info.gridworld.grid.Location;

import java.util.ArrayList;

/**
 * Copyright Mohsin created on 1/20/2016 for bugs
 * com.bugs.gridworld.mogey
 */
public class QuickCrab extends CrabCritter{
    @Override
    public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
                { Location.LEFT, Location.RIGHT };
        for (Location loc : getLocationsInDirections(dirs))
            if (getGrid().get(loc) == null)
                locs.add(loc);

        return locs;
    }

    /**
     * If the crab critter doesn't move, it randomly turns left or right.
     */
    @Override
    public void makeMove(Location loc)
    {
        if (loc.equals(getLocation()))
        {
            double r = Math.random();
            int angle;
            if (r < 0.5)
                angle = Location.LEFT;
            else
                angle = Location.RIGHT;
            setDirection(getDirection() + angle);
        }
        else
            super.makeMove(loc);
    }
}
