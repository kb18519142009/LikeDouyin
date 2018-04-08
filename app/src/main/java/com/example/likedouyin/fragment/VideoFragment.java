package com.example.likedouyin.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.likedouyin.R;

/**
 * Description：
 * Created by kang on 2018/4/2.
 */

public class VideoFragment extends Fragment {
    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.frag_video, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTextView = view.findViewById(R.id.tv_title);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String title = bundle.getString("title");
            mTextView.setText(title);
        }
    }
}
