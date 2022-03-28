package com.uce.musicplayer.rstructure;

public interface ListInterface {
    //Return true if the list is empty
    public boolean isEmpty();
    //Returns the size of the list
    public int size();
    //Add Object at the end of the list
    public void addEnd(Object x);
    //Remove the object at the beginning of the list
    public void remove();
    //Remove the object at the beginning of the list
    public void removeEnd();
}
