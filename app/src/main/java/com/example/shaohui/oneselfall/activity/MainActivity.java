package com.example.shaohui.oneselfall.activity;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.shaohui.oneselfall.R;
import com.example.shaohui.oneselfall.common.cache.DiskCache;
import com.example.shaohui.oneselfall.common.cache.DoubleCache;
import com.example.shaohui.oneselfall.common.cache.ImageCache;
import com.example.shaohui.oneselfall.common.cache.ImageLoader;
import com.example.shaohui.oneselfall.common.cache.MemoryCache;
import com.example.shaohui.oneselfall.common.clock.CountShowedClockView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.AlertDialog.Builder;
import static android.app.AlertDialog.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button2)
    Button button2;
    @BindView(R.id.csc_show)
    CountShowedClockView cscShow;

    private int allNumberAll = 998;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_view_activity);
        ButterKnife.bind(this);

        initView();
        initData();

    }

    private void initView() {


    }

    private void initData() {
        ImageLoader imageLoader = new ImageLoader();
        imageLoader.setmImageCache(new MemoryCache());
        imageLoader.setmImageCache(new DiskCache());
        imageLoader.setmImageCache(new DoubleCache());
        imageLoader.setmImageCache(new ImageCache() {
            @Override
            public Bitmap get(String url) {
                return null;
            }

            @Override
            public void put(String url, Bitmap bitmap) {

            }
        });


    }

    @OnClick({R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button2:
                allNumberAll = allNumberAll - 1;
                cscShow.setChangeNumber(String.valueOf(allNumberAll));

                showDialog();
                break;
        }
    }

    private void showDialog() {
        Builder builder = new Builder(this);
        builder.setIcon(R.drawable.ic_launcher_foreground);
        builder.setTitle("选择");
        builder.setMessage("试试学习喽，进步啊");
        builder.setPositiveButton("进步喽", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setTitle("进步喽");
            }
        });
        builder.setNeutralButton("加油喽", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setTitle("加油喽");
            }
        });
        builder.setNegativeButton("一般喽", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                setTitle("一般喽");
            }
        });
        builder.show();
    }
}
