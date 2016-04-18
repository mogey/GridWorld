package com.mogey.gridworld.marques.DataStructures;

import java.util.ArrayList;
import com.mogey.gridworld.marques.DataStructures.Node;
/**
 * Created by mohsin on 4/18/16.
 */
public class SortedNoNegDoublyLinkedList {
    private Node head = null;
    private Node tail = head;
    private int size = 0;
    public SortedNoNegDoublyLinkedList() {
    }

    public SortedNoNegDoublyLinkedList(ArrayList<Integer> list){
        for (int n: list) add(n);
    }
    public SortedNoNegDoublyLinkedList(int[] a){
        for (int n: a)
            add(n);
    }
    /*
    TODO REWRITE THIS FOR DOUBLY LINKED LIST, HAS REDUNDANT CODE AND DOESN'T SETUP BACK LINKS
     */
    public void add(int n){
        //If we're positive lets insert
        if(n >= 0) {
            Node before = null;
            Node current = null;
            Node insertMe = new Node(n);
            boolean inserted = false;
            if (head == null) {// head doesnt exist
                head = insertMe;
                updateTail();
            } else if (insertMe.getData() <= head.getData()) {// we're less than head
                insertMe.setNext(head);
                head.setPrev(insertMe);
                head = insertMe;
                updateTail();
            } else {
                before = head;
                current = head.getNext();
                while (current != null) {// we're in between these two numbers
                    if (insertMe.getData() >= before.getData() && insertMe.getData() <= current.getData()) {
                        before.setNext(insertMe);
                        insertMe.setPrev(before);
                        current.setPrev(insertMe);
                        insertMe.setNext(current);
                        inserted = true;
                        updateTail();
                        break;
                    } else {//iterate
                        before = current;
                        current = current.getNext();
                    }
                }
                if (!inserted) {//just fuck it and add ourselves to head
                    before.setNext(insertMe);
                    insertMe.setPrev(before);
                }
            }
        }

        if(n < 0){
            int c = Math.abs(n);
            Node closest = head;
            Node current = head;
            //Search for closest node
            while(current != null){
                if(Math.abs(current.getData() - c) < Math.abs(closest.getData() - c)){
                    closest = current;
                }
                current = current.getNext();
            }
            //Remove closest node
            Node before = head;
            current = head.getNext();
            if(closest == head){
                head = head.getNext();
            }
            while(current != null){
                //TODO THIS PART DOESNT DEAL WITH DOUBLY LINKED LISTS FIX IT
                if(current == closest){
                    before.setNext(current.getNext());
                    current.setNext(null);
                    break;
                }
                before = current;
                current = current.getNext();
            }
        }
    }

    public void insert(Node n, int index){
        if(index == 0){
            n.setNext(head);
            head = n;
        }
        int count = 0;
        Node current = head;
        while(current.getNext() != null){
            if(count == index){

            }
            current = current.getNext();
            count++;
        }
    }

    @Override
    public String toString() {
        return head + "";
    }
    public void updateTail(){
        Node current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        tail = current;
    }
}

