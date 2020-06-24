package com.example.shaohui.oneselfall.snow;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;

import com.example.shaohui.oneselfall.R;
import com.example.shaohui.oneselfall.snow.view.FallObject;
import com.example.shaohui.oneselfall.snow.view.FallingView;

/**
 * Created By shao
 * on 2020-01-17
 * <p>
 * 描述: 雪花动效
 */
public class SnowActivity extends Activity {

    FallingView fv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snow);

        initView();
    }

    private void initView() {

        FallObject.Builder builder = new FallObject.Builder(getResources().getDrawable(R.drawable.ic_snow_one));
        FallObject fallObject = builder
                .setSpeed(5, true)
                .setSize(50, 50, true)
                .setWind(5, true, true)
                .build();

        FallObject.Builder builderTwo = new FallObject.Builder(getResources().getDrawable(R.drawable.ic_snow_two));
        FallObject fallTwoObject = builderTwo
                .setSpeed(4, true)
                .setSize(50, 50, true)
                .setWind(5, true, true)
                .build();

        FallObject.Builder builderThree = new FallObject.Builder(getResources().getDrawable(R.drawable.ic_snow_three));
        FallObject fallThreeObject = builderThree
                .setSpeed(3, true)
                .setSize(50, 50, true)
                .setWind(5, true, true)
                .build();

        FallObject.Builder builderFour = new FallObject.Builder(getResources().getDrawable(R.drawable.ic_snow_four));
        FallObject fallFourObject = builderFour
                .setSpeed(2, true)
                .setSize(50, 50, true)
                .setWind(5, true, true)
                .build();

        fv = findViewById(R.id.fv);
        fv.addFallObject(fallObject, 1);
        fv.addFallObject(fallTwoObject, 2);
        fv.addFallObject(fallThreeObject, 3);
        fv.addFallObject(fallFourObject, 4);

    }
}
