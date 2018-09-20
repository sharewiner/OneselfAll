package com.example.shaohui.oneselfall.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.shaohui.oneselfall.R;

@SuppressLint("AppCompatCustomView")
public class MyTextView extends TextView {
    Context context;
    Paint mPaint;
    int color;

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initPaint();
    }

    public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    public MyTextView(Context context, int colorPrimaryDark) {
        this(context, null);
        color = colorPrimaryDark;
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setARGB(255, 0, 0, 0);//设置Paint对象颜色，参数一为alpha透明通道
        mPaint.setAlpha(255);
        mPaint.setColor(color);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int radius = getMeasuredWidth() / 5;
        int radiusCut = radius - 3;
        int radiusAdd = radius + 3;
        int space = radius / 6;

//        canvas.drawRect(0, getMeasuredHeight() / 2 - space, getMeasuredWidth(), getMeasuredHeight() / 2 + space, mPaint);
////        // 设置个新的长方形，60为左上点的x坐标，100为左上点的y坐标；200为右下点的 x坐标，240为右下点的y坐标。
////        RectF oval1 = new RectF(-radiusCut
////                , getMeasuredHeight() / 2 - radiusAdd
////                , radiusCut
////                , getMeasuredHeight() / 2 + radiusAdd);
////
////        RectF oval2 = new RectF(getMeasuredWidth() - radiusCut
////                , getMeasuredHeight() / 2 - radiusAdd,
////                getMeasuredWidth() + radiusCut
////                , getMeasuredHeight() / 2 + radiusAdd);
////        // 画弧，第一个参数是RectF：该类是第二个参数是角度的开始，第三个参数是多少度，第四个参数是真的时候画扇形，是假的时候画弧     线
////        canvas.drawArc(oval1, 270, 180, true, mPaint);
////        canvas.drawArc(oval2, 90, 180, true, mPaint);
        super.onDraw(canvas);
    }

}

