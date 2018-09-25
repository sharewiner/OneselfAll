package com.example.shaohui.oneselfall.been;

public class Director {


    Builder mBuilder = null;


    public Director(Builder builder) {
        mBuilder = builder;
    }


    public void connstruct(String board, String display) {
        mBuilder.buildBoard(board);
        mBuilder.buildDisplay(display);
        mBuilder.buildOS();
    }
}
