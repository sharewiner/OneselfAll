package com.example.shaohui.oneselfall;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import com.example.shaohui.oneselfall.been.UserInfo;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.OkHttpNetworkExecutor;
import com.yanzhenjie.nohttp.rest.RequestQueue;

public class MyApplication extends Application {

    //请求队列
    private static RequestQueue mRequestQueue;
    public static RequestQueue getmRequestQueue(){
        return mRequestQueue;
    }

    private static MyApplication _instance;

    //判断是否被回收
    public static int flag = -1;

    /**
     * 用户信息
     */
    private UserInfo userInfo;
    /**
     * 设置token
     */
    private String token = "";
    /**
     * token
     */
    private String onceToken = "";

    //static 代码段可以防止内存泄露
    static {
        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(R.color.white, android.R.color.darker_gray);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });
    }


    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;

        //该代码是在7.0以上版本之后向系统发送url的时候系统拿不到url,这样就不能在自动升级的时候打开app自动安装
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }

        //网络请求自定义初始化
        NoHttp.initialize(this);
        //请求队列
        mRequestQueue = NoHttp.newRequestQueue();

        Logger.setDebug(true);// 开启NoHttp的调试模式, 配置后可看到请求过程、日志和错误信息。
        Logger.setTag("NoHttpSample");// 打印Log的tag。
    }

    public static MyApplication getInstance() {
        return _instance;
    }

    public static void set_instance(MyApplication _instance) {
        MyApplication._instance = _instance;
    }

    public static int getFlag() {
        return flag;
    }

    public static void setFlag(int flag) {
        MyApplication.flag = flag;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getOnceToken() {
        return onceToken;
    }

    public void setOnceToken(String onceToken) {
        this.onceToken = onceToken;
    }
}
