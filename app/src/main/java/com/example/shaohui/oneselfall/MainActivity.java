package com.example.shaohui.oneselfall;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.example.shaohui.oneselfall.base.BasicActivity;
import com.example.shaohui.oneselfall.common.energy.EnergyView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BasicActivity implements Handler.Callback {

    @BindView(R.id.energy)
    EnergyView energy;
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;

    private Handler handler = new Handler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        energy.setMaxProgress(100);

    }

    @OnClick({R.id.btn1, R.id.btn2, R.id.btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                energy.setEmptyVisibility(View.GONE);
                break;
            case R.id.btn2:
                handler.sendEmptyMessage(0);
                break;
            case R.id.btn3:
                energy.clearProgress();
                energy.setEmptyVisibility(View.VISIBLE);
                break;
        }
    }


    @Override
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                energy.setProgress(energy.getCurrentProgress() + 1);
                if (energy.getCurrentProgress() < 100) {
                    handler.sendEmptyMessageDelayed(0, 300);
                }
                break;
        }
        return false;
    }
}