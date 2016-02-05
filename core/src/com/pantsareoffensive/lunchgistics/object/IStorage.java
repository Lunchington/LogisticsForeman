package com.pantsareoffensive.lunchgistics.object;

public interface IStorage {
    int  getInventorySpace();
    boolean hasSpace();
    boolean canInsert(GameObject obj);
    boolean canIRemove(GameObject obj);
    void putInventory(GameObject obj);
}
