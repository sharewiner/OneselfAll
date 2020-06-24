package com.example.shaohui.oneselfall.splash;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.shaohui.oneselfall.MainActivity;
import com.example.shaohui.oneselfall.MyApplication;
import com.example.shaohui.oneselfall.R;
import com.example.shaohui.oneselfall.snow.SnowActivity;

public class SplashActivity extends Activity {
    //储存信息
    private SharedPreferences recordPreferences;
    //共享参数 用来传递信息
    private SharedPreferences recordpreferencesyindao;
    // 屏幕宽度
    private int screenWidth = 0;
    //    private Request<String> request;
    private MyApplication myApplication;

    private String url = "";
    private String isForced = "";
    private Dialog newDownLoadDialog;
//    /*

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // 避免从桌面启动程序后，会重新实例化入口类的activity
        if (!this.isTaskRoot()) {
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(action)) {
                    finish();
                    return;
                }
            }
        }

        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        screenWidth = wm.getDefaultDisplay().getWidth();
        myApplication = (MyApplication) this.getApplication();

        recordpreferencesyindao = getSharedPreferences("yindao", Context.MODE_PRIVATE);

        MyApplication.flag = 0;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                autoLogin();
            }
        }, 3000);
    }

    /**
     * 自动登录
     */
    public void autoLogin() {
        Intent intents = new Intent();
        intents.setClass(this, SnowActivity.class);
        intents.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intents);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        finish();
    }
}
