package com.example.likedouyin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.likedouyin.R;
import com.example.likedouyin.view.VerticalViewPager;

/**
 * Description：
 * Created by kang on 2018/4/2.
 */

public class VerticalFragment extends Fragment {
    private static final String TAG = "VerticalFragment";
    private VerticalViewPager mVerticalViewPager;

    private int mPostion;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_vertical, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mVerticalViewPager = view.findViewById(R.id.vertical_view_pager);
        mVerticalViewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                VideoFragment videoFragment = new VideoFragment();
                Bundle bundle = new Bundle();
                bundle.putString("title", "我是视频" + position);
                videoFragment.setArguments(bundle);
                return videoFragment;
            }

            @Override
            public int getCount() {
                return 3;
            }
        });

        mVerticalViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.e(TAG, "onPageSelected: " + position);
                mPostion = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public int getPostion() {
        return mPostion;
    }
}
