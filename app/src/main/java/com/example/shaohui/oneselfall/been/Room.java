package com.example.shaohui.oneselfall.been;

public class Room {

    public float area;

    public float price;

    public Room(float area, float price) {
        this.area = area;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room [" + area + ", price=" + price + "]";
    }
}
