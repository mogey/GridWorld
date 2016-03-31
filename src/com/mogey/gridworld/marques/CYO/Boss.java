package com.mogey.gridworld.marques.CYO;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.Random;

/**
 * Created by mqureshi16 on 3/15/2016.
 */
public class Boss extends Actor {
    private int health = 5;
    private Grid grid = getGrid();
    private Random r = new Random();
    private Player p;

    public Boss() {
        setColor(null);
    }
    public void turn(){
        switch (r.nextInt(4)) {
            case 0:
                setDirection(Location.NORTH);
                break;
            case 1:
                setDirection(Location.EAST);
                break;
            case 2:
                setDirection(Location.SOUTH);
                break;
            case 3:
                setDirection(Location.WEST);
                break;
        }
    }
    public boolean canMove()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return false;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (!gr.isValid(next))
            return false;
        Actor neighbor = gr.get(next);
        return (neighbor == null) || (neighbor instanceof Flower);
        // ok to move into empty location or onto flower
        // not ok to move onto any other actor
    }
    public void move()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
            moveTo(next);
        else
            removeSelfFromGrid();
    }

    public void act(){
        System.out.println("\nSTEPPED\n");
        grid = getGrid();
        if(getPlayer() == null){
            System.out.println("BOSS WON");
            setDirection(r.nextInt(366));
            move();
            return;
        }else{
            p = getPlayer();
            System.out.println("Player position is: "+p.getLocation());
        }
        if(canMove()) {
            turn();
            move();
        }
        else
            turn();
        //Check if we should die
        if(health <= 0){
            System.out.println("Boss died");
            removeSelfFromGrid();
            return;
        }
        checkAttacks();
        Attack();
        System.out.println("Boss health is "+health);
    }

    private Player getPlayer(){

        for(Location a: getGrid().getOccupiedLocations()){
            if(grid.get(a) instanceof Player){
                return (Player)grid.get(a);
            }
        }
        return null;
    }
    private void Attack(){
        if(r.nextBoolean()) {
            Location pLoc = p.getLocation();
            Attack t = new Attack();
            t.putSelfInGrid(getGrid(), pLoc.getAdjacentLocation(pLoc.getDirectionToward(this.getLocation())));
            System.out.println("Boss attacked this step");
        }else{
            System.out.println("Boss did not attack this step");
        }
    }
    private void checkAttacks(){
        for(Location b: getGrid().getOccupiedAdjacentLocations(getLocation())){
            if(grid.get(b) instanceof Attack){
                Attack atkB = (Attack)grid.get(b);
                if(r.nextInt(atkB.chance) == 1){
                    System.out.println("Player did damage to boss for "+atkB.damage);
                    this.health -= atkB.damage;
                    atkB.removeSelfFromGrid();
                }else{
                    System.out.println("Player missed!");
                }
            }
        }
    }

}
