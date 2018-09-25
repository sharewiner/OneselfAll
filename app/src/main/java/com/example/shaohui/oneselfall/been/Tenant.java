package com.example.shaohui.oneselfall.been;

public class Tenant {

    public float roomArea;
    public float roomPrice;
    public static final float diffPrice = 100.0001f;
    public static final float diffArea = 0.00001f;

    public void rentRoom(Meditor meditor) {

        System.out.println("租到房间啦" + meditor.rentOut(roomPrice, roomArea));

    }


}
