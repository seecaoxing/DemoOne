package com.see.demoone;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by see on 2016/7/16.
 */
public class MyViewOne extends View {
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MyViewOne(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //当包含此view的activity退出时此方法被调用
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    //包含此view的activity启动时此方法被调用
    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
