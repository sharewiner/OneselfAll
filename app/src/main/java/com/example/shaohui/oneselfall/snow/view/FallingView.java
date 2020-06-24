package com.example.shaohui.oneselfall.snow.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By shao
 * on 2020-01-17
 * <p>
 * 描述:下落物体
 */
public class FallingView extends View {

    private int viewWidth;
    private int viewHeight;

    private static final int defaultWidth = 600;//默认宽度
    private static final int defaultHeight = 1000;//默认高度
    private static final int intervalTime = 7;//重绘间隔时间

    List<FallObject> fallObjectList;

    public FallingView(Context context) {
        super(context);
        init();
    }

    public FallingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FallingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        fallObjectList = new ArrayList<>();
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int height = measureSize(defaultHeight, heightMeasureSpec);
        int width = measureSize(defaultWidth, widthMeasureSpec);
        setMeasuredDimension(width, height);

        viewHeight = height;
        viewWidth = width;
    }

    private int measureSize(int defaultSize, int measureSpec) {
        int result = defaultSize;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSize = View.MeasureSpec.getSize(measureSpec);

        if (specMode == View.MeasureSpec.EXACTLY) {
            result = specSize;
        } else if (specMode == View.MeasureSpec.AT_MOST) {
            result = Math.min(result, specSize);
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (fallObjectList.size() > 0) {
            for (int i = 0; i < fallObjectList.size(); i++) {
                fallObjectList.get(i).drawObject(canvas);
            }

            getHandler().postDelayed(runable, intervalTime);
        }
    }

    private Runnable runable = new Runnable() {
        @Override
        public void run() {
            invalidate();
        }
    };

    public void addFallObject(final FallObject fallObject, final int num) {
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                getViewTreeObserver().removeOnPreDrawListener(this);
                for (int i = 0; i < num; i++) {
                    FallObject newFallObject = new FallObject(fallObject.builder, viewWidth, viewHeight);
                    fallObjectList.add(newFallObject);
                }
                invalidate();
                return true;
            }
        });
    }
}
