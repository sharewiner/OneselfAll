package com.example.shaohui.oneselfall.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.example.shaohui.oneselfall.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LeftRightSlideActivity extends Activity {

    @BindView(R.id.btn_qiehuan)
    Button btnQiehuan;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_right_slide);
        ButterKnife.bind(this);


    }

    /**
     * 切换
     * 测试滑动切换activity
     */
    @OnClick(R.id.btn_qiehuan)
    public void onViewClicked() {
        Intent ii = new Intent(this, CateActivity.class);
        startActivity(ii);
        overridePendingTransition(R.anim.out_to_left, R.anim.in_from_right);
    }
}
