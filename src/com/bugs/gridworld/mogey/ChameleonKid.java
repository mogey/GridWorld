package com.bugs.gridworld.mogey;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

/**
 * Copyright RC created on 1/19/2016 for bugs
 * com.bugs.gridworld.mogey
 *
 * A ChameleonKid changes its color to the color
 * of one of the actors immediately in front or behind.
 * If there is no actor in either of these locations,
 * then the ChameleonKid darkens like the modified ChameleonCritter.
 */
public class ChameleonKid extends ChameleonCritter{
    public ChameleonKid(){}
        public void move() {
            Grid<Actor> gr = getGrid();
            if (gr == null)
                return;
            Location loc = getLocation();
            Location next = loc.getAdjacentLocation(getDirection());
            if (gr.isValid(next))
                moveTo(next);
            else
                removeSelfFromGrid();

            Actor front = (gr.isValid(loc.getAdjacentLocation(getDirection())))?(gr.get(loc.getAdjacentLocation(getDirection()))):null;
            Actor behind = (gr.isValid(loc.getAdjacentLocation(getDirection()+180)))?(gr.get(loc.getAdjacentLocation(getDirection()+180))):null;

            if (front!=null){
                setColor(front.getColor());
            }
            if(behind!= null) {
                setColor(behind.getColor());
            }
            else{setColor(getColor().darker());}
        }

    }