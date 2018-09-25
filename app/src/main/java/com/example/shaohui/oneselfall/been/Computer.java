package com.example.shaohui.oneselfall.been;

public abstract class Computer {

    protected String mRoard;
    protected String mDisplay;
    protected String mOS;

    protected Computer() {

    }

    public void setRoard(String roard) {
        mRoard = roard;
    }

    public void setDisplay(String display) {
        mDisplay = display;
    }

    public abstract void setOS();


    @Override
    public String toString() {
        return "Computer [" +
                "mRoard='" + mRoard +
                ", mDisplay='" + mDisplay +
                ", mOS='" + mOS + ']';
    }
}
