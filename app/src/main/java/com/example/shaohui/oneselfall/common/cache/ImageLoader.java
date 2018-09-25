package com.example.shaohui.oneselfall.common.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageLoader {
    //图片缓存
    ImageCache mImageCache = new MemoryCache();
    //线程池，线程数量为CPU的数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    //注入缓存实现
    public void setmImageCache(ImageCache mImageCache) {
        this.mImageCache = mImageCache;
    }

    public void displayImage(String imageUrl, ImageView imageView) {
        Bitmap bitmap = mImageCache.get(imageUrl);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }

        //图片没有缓存，提交线程池下载图片
        submitLoadRequest(imageUrl, imageView);
    }

    private void submitLoadRequest(final String imageUrl, final ImageView imageView) {
        imageView.setTag(imageUrl);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(imageUrl);
                if (bitmap == null) {
                    return;
                }

                if (imageView.getTag().equals(imageUrl)) {
                    imageView.setImageBitmap(bitmap);
                }

                mImageCache.put(imageUrl, bitmap);
            }
        });
    }

    private Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return bitmap;
    }
}
