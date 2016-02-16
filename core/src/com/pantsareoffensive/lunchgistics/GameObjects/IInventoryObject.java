package com.pantsareoffensive.lunchgistics.GameObjects;

public interface IInventoryObject {
    //How many inventory spaces it takes up
    int getSize();

    //can you move it by hand?
    boolean canMoveByHand();

    //how heavy is it?
    int getWeight();

}
