package com.mogey.gridworld.marques.CYO;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Bug;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import javax.swing.*;
import java.awt.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by mqureshi16 on 3/15/2016.
 */
public class Player extends Actor {
    private Location myLoc;
    private int health = 5;
    private Grid grid = getGrid();
    private Random r = new Random();
    private Boss b;

    public Player(){
        setColor(null);
    }
    @Override
    public void act(){
        System.out.println("\nSTEPPED\n");
        //Check if we should die
        if(health <= 0){
            System.out.println("Player died");
            removeSelfFromGrid();
            return;
        }
        checkAttacks(); //Checks for any attack objects in adjacent locations
        grid = getGrid();
        myLoc = getLocation();
        if(getBoss() == null){
            System.out.println("PLAYER WON");
            setDirection(r.nextInt(366));
            move();
            return;
        }else{
            b = getBoss();
            System.out.println("Boss position is: "+b.getLocation());
        }
        String s = JOptionPane.showInputDialog("Enter a command\n(Attack|attack|a)\n(Move|move|m)\nEnter a blank to step");
        if(s.equals("attack") || s.equals("Attack") || s.equals("a")){
            int r = Integer.parseInt(JOptionPane.showInputDialog("Enter a row"));
            int c = Integer.parseInt(JOptionPane.showInputDialog("Enter a column"));
            Location a = new Location(r,c);
            if(grid.isValid(a)){
                attack(a);
            }
        }
        if(s.equals("move") || s.equals("Move") || s.equals("m")){
            String choice = JOptionPane.showInputDialog("Enter a movement\nw = up\ns = down\nd = right\ns = right");
            Location a = getLocation();
            Location l = getLocation();
            if(choice.equals("w")){
                a = new Location(l.getRow()-1,l.getCol());
            }
            if(choice.equals("s")){
                a = new Location(l.getRow()+1,l.getCol());
            }
            if(choice.equals("d")){
                a = new Location(l.getRow(),l.getCol()+1);
            }
            if(choice.equals("a")){
                a = new Location(l.getRow(),l.getCol()-1);
            }
            if(grid.isValid(a)){
                moveTo(a);
            }
        }
        System.out.println("Player health is "+health);

    }
    private Boss getBoss(){
        for(Location a: getGrid().getOccupiedLocations()){
            if(grid.get(a) instanceof Boss){
                return (Boss)grid.get(a);
            }
        }
        return null;
    }
    private void attack(Location a){
        if(grid.isValid(a)) {
            Attack t = new Attack();
            t.putSelfInGrid(grid,a);
        }

    }
    private void checkAttacks(){
        for(Location b: getGrid().getOccupiedAdjacentLocations(getLocation())){
            if(grid.get(b) instanceof Attack){
                Attack atkB = (Attack)grid.get(b);
                if(r.nextInt(atkB.chance) == 1){
                    System.out.println("Boss did damage to player for "+atkB.damage);
                    this.health -= atkB.damage;
                    atkB.removeSelfFromGrid();
                }else{
                    System.out.println("Boss missed!");
                }
            }
        }
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
    }
}
