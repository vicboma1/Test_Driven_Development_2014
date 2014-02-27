package com.akamon.tdd.gildedRoseRefactor.item;

public class Item {

    public String name;
    public int sellIn;
    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
