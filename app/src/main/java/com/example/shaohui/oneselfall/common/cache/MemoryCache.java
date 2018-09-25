package com.example.shaohui.oneselfall.common.cache;


import android.graphics.Bitmap;
import android.util.LruCache;

public class MemoryCache implements ImageCache {

    private LruCache<String, Bitmap> mMemeryCache;

    public MemoryCache() {

    }

    @Override
    public Bitmap get(String url) {
        return mMemeryCache.get(url);
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mMemeryCache.put(url, bitmap);
    }
}
