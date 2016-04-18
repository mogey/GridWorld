package com.mogey.gridworld.marques.DataStructures;

/**
 * Created by mohsin on 4/18/16.
 */
public class Node {
    private Node next;
    private Node prev;

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    private int data;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node:{" +  "ID=("+this.hashCode()+")" + "\nData:" + data + "\nNext:\n\n(" + next + ")}\n";
    }
}
