package com.mogey.gridworld.marques.FlowerGame;

import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Location;
import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.util.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by mqureshi16 on 3/24/2016.
 */
public class FlowerCritter extends Critter {
    ActorWorld world;

    public FlowerCritter(ActorWorld world) {
        this.world = world;
    }

    public void act() {
        /*
        if (getGrid() == null)
            return;
        ArrayList<Actor> actors = getActors();
        processActors(actors);
        ArrayList<Location> moveLocs = getMoveLocations();
        Location loc = selectMoveLocation(moveLocs);
        makeMove(loc);*/
        Queue<Location> path = findPath(getLocation(), new Location(7, 4));
        makeMove(path.poll());
    }

    /*
    Create a 'frontier'
    add ourselves to the frontier
    Create a visited set
    add our location as visitted
    while the frontier is not empty
    set current to the next location in frontier
    for each neighbor of our location check if visitted
    if not visitted put it in frontier
    and set it visitted
     */
    private Queue findPath(Location start, Location goal) {
        HashSet<Location> open = new HashSet<Location>();
        open.add(getLocation());

        HashSet<Location> closed = new HashSet<Location>();

        Map<Location, Location> cameFrom = new HashMap<Location, Location>();

        Map<Location, Integer> fScore = new HashMap<Location, Integer>(); //h + g
        fScore.put(start, distBetween(start, goal));

        Map<Location, Integer> gScore = new HashMap<Location, Integer>(); //cost from start to here
        gScore.put(start, 0);


        while (!open.isEmpty()) {
            Location current = findSmallest(open, fScore);
            System.out.println("Current is: " + current);
            open.remove(current);
            closed.add(current);

            for (Location next : getGrid().getValidAdjacentLocations(current)) {
                System.out.println("Checking next: " + next);
                if (closed.contains(next))
                    continue;
                int tentativegScore = gScore.get(current) + distBetween(current, next);
                if (!(open.contains(next))) {
                    open.add(next);
                } else if (tentativegScore >= gScore.get(next)) {
                    continue;
                }
                cameFrom.put(next,current);
                gScore.put(next,tentativegScore);
                fScore.put(next,gScore.get(next) + distBetween(next,goal));
            }
        }
        Queue<Location> path = new LinkedList<Location>();
        Location current = start;
        while(cameFrom.containsKey(current)){
            path.add(cameFrom.get(current));
        }
        return path;
    }

    private Location findSmallest(HashSet a, Map f) {
        Iterator<Location> i = a.iterator();
        Location s = i.next();
        while (i.hasNext()) {
            if ((Integer) f.get((Location) i.next()) < (Integer) f.get((Location) s)) {
                s = i.next();
            }
        }
        return s;
    }

    private int distBetween(Location a, Location b) {
        return (Math.abs(a.getCol() - b.getCol()) + Math.abs(a.getRow() - b.getRow()));
    }

    private class gScoreComparator implements Comparator<Integer> {
        public gScoreComparator() {

        }

        public int compare(Integer a, Integer b) {
            return 0;
        }
    }


}
