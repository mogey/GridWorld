package com.mogey.gridworld.marques.DataStructures;

import java.util.ArrayList;
import com.mogey.gridworld.marques.DataStructures.Node;
/**
 * Created by mohsin on 4/18/16.
 */
public class SortedNoNegLinkedList {
    private Node head = null;
    private int size = 0;
    public SortedNoNegLinkedList() {
    }

    public SortedNoNegLinkedList(ArrayList<Integer> list){
        for (int n: list) {
            add(n);
        }
    }
    public SortedNoNegLinkedList(int[] a){
        for (int n: a
             ) {
            add(n);
        }
    }
    public void add(int n){
        //If we're positive lets insert
        if(n >= 0) {
            Node before = null;
            Node current = null;
            Node insertMe = new Node(n);
            boolean inserted = false;
            if (head == null) {// head doesnt exist
                head = insertMe;
            } else if (insertMe.getData() <= head.getData()) {// we're less than head
                insertMe.setNext(head);
                head = insertMe;
            } else {
                before = head;
                current = head.getNext();
                while (current != null) {// we're in between these two numbers
                    if (insertMe.getData() >= before.getData() && insertMe.getData() <= current.getData()) {
                        before.setNext(insertMe);
                        insertMe.setNext(current);
                        inserted = true;
                        break;
                    } else {//iterate
                        before = current;
                        current = current.getNext();
                    }
                }
                if (!inserted) {//just fuck it and add ourselves to head
                    before.setNext(insertMe);
                }
            }
        }
        if(n < 0){
            int c = Math.abs(n);
            Node closest = head;
            Node current = head;
            while(current != null){
                if(Math.abs(current.getData() - c) < Math.abs(closest.getData() - c)){
                    closest = current;
                }
                current = current.getNext();
            }
            Node before = head;
            current = head.getNext();
            if(closest == head){
                head = head.getNext();
            }
            while(current != null){
                if(current == closest){
                    before.setNext(current.getNext());
                    current.setNext(null);
                    current = null;
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
}
