package com.uce.musicplayer.rstructure;

public class Node {
    private Object data;
    private Node next;

    public Node(Object x) {
        data = x;
        next = null;
    }

    public Node (Object x, Node next){
        data = x;
        next = next;
    }

    public void setData(Object o){
        data = o;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
