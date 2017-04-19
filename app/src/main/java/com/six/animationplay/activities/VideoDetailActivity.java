package com.six.animationplay.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.six.animationplay.R;
import com.six.animationplay.fragment.VideoFeedBackFragment;
import com.six.animationplay.fragment.VideoIntroductionFragment;
import com.six.animationplay.model.VideoDetailBean;
import com.six.animationplay.presenters.videoDetail.VideoDetailContract;
import com.six.animationplay.presenters.videoDetail.VideoDetailPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/14.
 */

public class VideoDetailActivity extends AppCompatActivity implements VideoDetailContract.View {

    private Toolbar mToolBar;
    private FloatingActionButton mFloatingBtn;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private ImageView mVideoPreview;
    private AppBarLayout mActionBar;

    private String[] mViewPagerTitle = {"简介", "评论"};

    private VideoDetailPresenter mPresenter;
    private String mVideoId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);

        mPresenter = new VideoDetailPresenter(this);
        initView();
        initData();
        initEvent();
    }

    private void initView() {
        mToolBar = (Toolbar) findViewById(R.id.video_toolbar);
        mFloatingBtn = (FloatingActionButton) findViewById(R.id.video_play_btn);
        mTabLayout = (TabLayout) findViewById(R.id.video_tab_layout);
        mViewPager = (ViewPager) findViewById(R.id.video_view_pager);
        mVideoPreview = (ImageView) findViewById(R.id.video_preview);
        mActionBar = (AppBarLayout) findViewById(R.id.video_app_bar_layout);
    }

    private void initData() {
        Intent intent = getIntent();
        if (intent != null) {
            mVideoId = intent.getStringExtra("av");
            mPresenter.getVideoDetailById(mVideoId);
        }

        List<Fragment> fragments = new ArrayList<>();
        VideoIntroductionFragment introductionFragment = new VideoIntroductionFragment();
        fragments.add(introductionFragment);
        VideoFeedBackFragment feedBackFragment = new VideoFeedBackFragment();
        fragments.add(feedBackFragment);

        VideoDetailAdapter adapter = new VideoDetailAdapter(getSupportFragmentManager(), fragments);
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initEvent() {
        mFloatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(VideoDetailContract.Presenter presenter) {
    }

    @Override
    public void getVideoDetailSuccess(VideoDetailBean detailBean) {
    }

    private class VideoDetailAdapter extends FragmentPagerAdapter {
        private List<Fragment> mFragmentList;

        public VideoDetailAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            mFragmentList = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mViewPagerTitle[position];
        }
    }
}
