package com.example.likedouyin.view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/**
 * Description：
 * Created by kang on 2018/3/30.
 */

public class InterceptFrameLayout extends FrameLayout {
    private static final String TAG = "InterceptFrameLayout";
    private Context mContext;

    private GestureDetector mGestureDetector;

    public InterceptFrameLayout(@NonNull Context context) {
        super(context);
        init();
    }

    public InterceptFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InterceptFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mContext = getContext();
//        Context context = getContext();
//        if (context instanceof Activity) {
        mGestureDetector = new GestureDetector(new HScrollDetector());
//        } else {
//            throw new RuntimeException("VideoBehaviorView context must be Activity");
//        }
        setFadingEdgeLength(0);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mGestureDetector.onTouchEvent(ev);
    }

    // Return false if we're scrolling in the y direction
    class HScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            if (Math.abs(distanceX) > Math.abs(distanceY)) {
                //TODO 左右滑动
                return true;
            }

            return false;
        }
    }
}
