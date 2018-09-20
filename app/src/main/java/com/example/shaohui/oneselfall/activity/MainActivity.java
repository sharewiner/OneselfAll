package com.example.shaohui.oneselfall.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.shaohui.oneselfall.R;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private static String tag = "okhttp测试";
    private String getContent = "";

    @BindView(R.id.bt_one)
    Button btOne;

    @BindView(R.id.tv_show_content)
    TextView tvShowContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    public void doGet(View view) throws IOException {
        //1.拿到okHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.构建request请求
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url("http://www.imooc.com/").build();
        //3.将request请求封装给call
        Call call = okHttpClient.newCall(request);
//        Response response = call.execute();
        //4.执行call
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(tag, "onFailure:" + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                getContent = response.body().string();
                Log.e(tag, "onResponse:" + getContent);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvShowContent.setText(getContent);
                    }
                });
            }
        });

    }
}
