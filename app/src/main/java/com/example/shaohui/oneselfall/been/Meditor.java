package com.example.shaohui.oneselfall.been;

import java.util.ArrayList;
import java.util.List;

public class Meditor {

    List<Room> mRooms = new ArrayList<>();

    public Meditor() {
        for (int i = 0; i < 5; i++) {
            mRooms.add(new Room(14 + i, (14 + i) * 150));
        }
    }

    public Room rentOut(float price, float area) {
        for (Room room : mRooms) {
            if (isSuitable(room, price, area)) {
                return room;
            }
        }
        return null;
    }

    private boolean isSuitable(Room room, float price, float area) {
        return Math.abs(room.price - price) < Tenant.diffPrice && Math.abs(room.area - area) < Tenant.diffArea;
    }
}
