package com.example.shaohui.oneselfall.been;

public class Singleton2 {

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        return Singletion2Holder.sInstance;
    }

    private static class Singletion2Holder {
        private static final Singleton2 sInstance = new Singleton2();
    }

}
