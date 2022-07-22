package com.uce.musicplayer.rstructure;

public class List<S> implements ListInterface{
    private Node beginning;
    private Node end;

    private int numberOfElements;

    public List(){
        beginning = end = null;
    }

    @Override
    public boolean isEmpty() {
        return beginning == null;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public void addEnd(Object x) {
        Node p = new Node(x, null);
        if(isEmpty())
            beginning=p;
        else
            end.setNext(p);
        end=p;
        numberOfElements++;
    }
    @Override
    public void remove() {
        Node aux = beginning;
        beginning = aux.getNext();
        numberOfElements--;
    }

    @Override
    public void removeEnd() {
        Node aux = beginning;
        while (aux.getNext() != null)
            aux= aux.getNext();
        end=aux;
        end.setNext(null);
        numberOfElements--;
    }

    public Node getBeginning() {
        return beginning;
    }

    public Node getEnd() {
        return end;
    }
}
