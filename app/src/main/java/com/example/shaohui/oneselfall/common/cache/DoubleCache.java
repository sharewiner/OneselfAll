package com.example.shaohui.oneselfall.common.cache;

import android.graphics.Bitmap;

/**
 * 双缓冲。获取图片时先从内存中获取，如果内存中没有缓存改图片，再从SD卡中获取。缓存图片也是在内存和SD卡中都缓存一份
 */
public class DoubleCache implements ImageCache {

    ImageCache mMemoryCache = new MemoryCache();
    DiskCache mDiskCache = new DiskCache();

    //先从内存缓存中获取图片，如果没有，再冲SD卡中获取图片
    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }

    //将图片缓存到内存和SD卡中
    public void put(String url, Bitmap bmp) {
        mMemoryCache.put(url, bmp);
        mDiskCache.put(url, bmp);
    }

}
