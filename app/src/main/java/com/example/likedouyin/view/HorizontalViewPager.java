package com.example.likedouyin.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * HorizontalViewPager
 * Created by kelseo on 2017/5/4.
 */
public class HorizontalViewPager extends ViewPager {
    private GestureDetector xScrollDetector;

    public HorizontalViewPager(Context context) {
        super(context);
        init();
    }

    public HorizontalViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        xScrollDetector = new GestureDetector(getContext(), new XScrollDetector());
    }

    private void init() {
        setOverScrollMode(OVER_SCROLL_NEVER);
    }

    private class XScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return Math.abs(distanceX) > Math.abs(distanceY) * 2.5;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (xScrollDetector.onTouchEvent(ev)) {
            super.onInterceptTouchEvent(ev);
            return true;
        }

        return super.onInterceptTouchEvent(ev);
    }

}
