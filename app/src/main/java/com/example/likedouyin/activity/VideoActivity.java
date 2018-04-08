package com.example.likedouyin.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.likedouyin.R;
import com.example.likedouyin.fragment.StoryFragment;
import com.example.likedouyin.fragment.UserInfoFragment;
import com.example.likedouyin.fragment.VerticalFragment;
import com.example.likedouyin.view.HorizontalViewPager;

public class VideoActivity extends AppCompatActivity {
    private static final String TAG = "VideoActivity";
    private HorizontalViewPager mHorizontalViewPager;

    private StoryFragment mStoryFragment;
    private VerticalFragment mVerticalFragment;
    private UserInfoFragment mUserInfoFragment;

    private boolean isFinish = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        mHorizontalViewPager = findViewById(R.id.horizontal_view_pager);
        mHorizontalViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    if (mStoryFragment == null) {
                        mStoryFragment = new StoryFragment();
                    }
                    return mStoryFragment;
                } else if (position == 1) {
                    if (mVerticalFragment == null) {
                        mVerticalFragment = new VerticalFragment();
                    }
                    return mVerticalFragment;
                } else {
                    if (mUserInfoFragment == null) {
                        mUserInfoFragment = new UserInfoFragment();
                    }
                    return mUserInfoFragment;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        mHorizontalViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.e(TAG, "position: " + position + " positionOffset: " + positionOffset + " positionOffsetPixels" + positionOffsetPixels);
                //当前页是第一页，并且是拖动状态，并且像素偏移量为0
                if (position == 0 && positionOffset == 0 && positionOffsetPixels == 0) {
                    if (isFinish) {
                        JumpToNext();
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
                Log.e(TAG, "onPageSelected: " + position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.e(TAG, "onPageScrollStateChanged: " + state);
                isFinish = state == 1; //当前为拖动状态
                if (state == 1) {
                    if (mUserInfoFragment != null && mVerticalFragment != null) {
                        mUserInfoFragment.setTitle("我是个人中心" + mVerticalFragment.getPostion());
                    }
                }
            }
        });
        mHorizontalViewPager.setCurrentItem(1);
    }

    private void JumpToNext() {

        finish();
    }
}
