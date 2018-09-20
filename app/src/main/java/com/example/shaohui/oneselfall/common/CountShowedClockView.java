package com.example.shaohui.oneselfall.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.shaohui.oneselfall.R;

import java.util.ArrayList;
import java.util.List;

public class CountShowedClockView extends HorizontalScrollView {
    private List<FlipClockView> flipClockViewList = new ArrayList<>();

    String[] startNumber;
    String[] changeNumber;
    private String startNumberValue = "";
    private String changeNumberValue = "";
    private float textSize;
    private float viewWidth;
    private float viewHeight;
    LinearLayout linearLayout;
    private LayoutParams mLayoutParams;

    private int clockCount = 1;

    private int space;
    private float countSpace;

    public CountShowedClockView(Context context) {
        this(context, null);
    }

    public CountShowedClockView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public CountShowedClockView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }

    @SuppressLint("NewApi")
    public void initView(Context context, AttributeSet attrs) {
        TypedArray tArray = context.obtainStyledAttributes(attrs,
                R.styleable.NewMyClock);
        textSize = tArray.getDimension(R.styleable.NewMyClock_countTextSize, 26f);
        int textColor = tArray.getColor(R.styleable.NewMyClock_countTextColor, 0xffffff);
        Drawable textBg = tArray.getDrawable(R.styleable.NewMyClock_countTextBackground);
        clockCount = tArray.getInteger(R.styleable.NewMyClock_countShowNumber, 1);

        countSpace = tArray.getDimension(R.styleable.NewMyClock_countSpace, 70);
        viewWidth = tArray.getDimension(R.styleable.NewMyClock_countWidth, 100);
        viewHeight = tArray.getDimension(R.styleable.NewMyClock_countHeight, 80);
        space = (int) countSpace;

        tArray.recycle();

        startNumber = new String[clockCount];
        changeNumber = new String[clockCount];

        linearLayout = new LinearLayout(context);
        mLayoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setLayoutParams(mLayoutParams);
        addView(linearLayout);

        flipClockViewList.clear();
        if (clockCount > 0) {
            for (int i = 0; i < clockCount; i++) {

                startNumber[i] = "0";
                changeNumber[i] = "0";

                FlipClockView flipClockView = new FlipClockView(context);
                flipClockView.setId(View.generateViewId());
//                flipClockView.setClockBackground(textBg);
                flipClockView.setClockBackground(context.getResources().getDrawable(R.drawable.ic_clock_bg));
                flipClockView.setClockTextSize(textSize);
                flipClockView.setClockTextColor(textColor);
                flipClockView.setClockTime("0");
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams((int) viewWidth, (int) viewHeight);
                flipClockView.setLayoutParams(lp);

                if (i == 1 || i == 4 || i == 7) {
                    lp.setMargins(space, 0, space, space * (7/4));
                } else {
                    lp.setMargins(0, 0, 0, space * (7/4));
                }

                linearLayout.addView(flipClockView);
                flipClockViewList.add(flipClockView);

                if (i == 2 || i == 5) {
                    RelativeLayout relativeLayout = new RelativeLayout(context);
                    LinearLayout.LayoutParams lprl = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
                    relativeLayout.setLayoutParams(lprl);

                    lprl.setMargins((int) (space * 2.5), 0, 0, 0);
                    TextView textView = new TextView(context);
                    textView.setText("，");
                    textView.setTextSize(textSize);
                    textView.setTextColor(getResources().getColor(R.color.gay));

                    RelativeLayout.LayoutParams lptv = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
                    lptv.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                    textView.setLayoutParams(lptv);
                    relativeLayout.addView(textView);

                    linearLayout.addView(relativeLayout);
                }
            }
        }
    }

    /**
     * 获取布局宽度
     */
    public int getScreenWidth(Context mContext) {
        return mContext.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 传入修改数据
     */
    public void setChangeNumber(String number) {
        changeNumberValue = number;
        if (!"".equals(changeNumberValue)) {
            int count = changeNumberValue.length();
            for (int i = 0; i < count; i++) {
                int a = clockCount - i - 1;
                changeNumber[a] = changeNumberValue.substring(count - i - 1, count - i);
            }
        }

        setRefreshNumber();
    }

    /**
     * 修改滑动
     */
    public void setRefreshNumber() {
        for (int i = 0; i < clockCount; i++) {
            int a = clockCount - i - 1;
            if (!changeNumber[a].equals(startNumber[a])) {
                startNumber[a] = changeNumber[a];

                flipClockViewList.get(a).setClockTime(changeNumber[a]);
                flipClockViewList.get(a).smoothFlip();

            }
        }

        startNumberValue = changeNumberValue;
        changeNumberValue = "";
    }


}

