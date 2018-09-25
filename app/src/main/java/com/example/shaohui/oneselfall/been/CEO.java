package com.example.shaohui.oneselfall.been;

/**
 * CEO 饿汉单列模式
 */
public class CEO extends Staff {
    private static final CEO mCeo = new CEO();

    //构造函数私有
    private CEO() {

    }

    public static CEO getCeo() {
        return mCeo;
    }

    @Override
    public void work() {
        //管理VP
    }
}
