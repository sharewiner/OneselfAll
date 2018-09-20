package com.example.shaohui.oneselfall.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.shaohui.oneselfall.R;
import com.example.shaohui.oneselfall.common.CountShowedClockView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.fc_bg_1)
//    FlipClockView fcBg1;
//    @BindView(R.id.fc_bg_2)
//    FlipClockView fcBg2;
//    @BindView(R.id.fc_bg_3)
//    FlipClockView fcBg3;
//    @BindView(R.id.fc_bg_4)
//    FlipClockView fcBg4;
//    @BindView(R.id.rl_all)
//    LinearLayout rlAll;
    @BindView(R.id.button2)
    Button button2;

    @BindView(R.id.csc_show)
    CountShowedClockView cscShow;

    private int allNumber = 0;
    private int allNumberAll = 998;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clock_view_activity);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.button2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button2:
                allNumberAll = allNumberAll - 1;
                cscShow.setChangeNumber(String.valueOf(allNumberAll));
                break;
        }
    }

}
