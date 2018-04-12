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
        setOverScrollMode(OVER_SCROLL_NEVER); //设置去掉滑到最左或最右时的滑动效果
    }

    private class XScrollDetector extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            // 横向滑动大于纵向滑动距离的2.5倍时返回true，更好的解决某些事件冲突问题
            return Math.abs(distanceX) > Math.abs(distanceY) * 2.5;
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (xScrollDetector.onTouchEvent(ev)) {
            super.onInterceptTouchEvent(ev);
            return true; //如果是横向滑动事件，就拦截事件，不再向下传递，自己消费事件
        }

        return super.onInterceptTouchEvent(ev);
    }

}
