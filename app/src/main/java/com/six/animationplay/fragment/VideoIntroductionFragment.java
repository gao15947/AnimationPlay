package com.six.animationplay.fragment;

import android.widget.TextView;

import com.six.animationplay.R;
import com.six.animationplay.model.VideoDetailBean;
import com.six.animationplay.presenters.videoDetail.VideoDetailContract;
import com.zhy.view.flowlayout.TagFlowLayout;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Administrator on 2017/4/14.
 */

public class VideoIntroductionFragment extends BaseFragment {

    private TextView mVideoTitle;
    private TextView mVideoPlayView;
    private TextView mVideoDanMu;
    private TextView mVideoIntroduction;
    private TextView mVideoShareNum;
    private TextView mVideoCoins;
    private TextView mVideoFavorites;
    private CircleImageView mUserIcon;
    private TextView mVideoAuthor;
    private TextView mCreateTime;
    private TextView mAttention;
    private TextView mTagEdit;
    private TagFlowLayout mTagsLayout;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_video_introduction;
    }

    @Override
    protected void initView() {
        mVideoTitle = (TextView) mRootView.findViewById(R.id.video_detail_title);
        mVideoPlayView = (TextView) mRootView.findViewById(R.id.video_detail_play_num);
        mVideoDanMu = (TextView) mRootView.findViewById(R.id.video_detail_danmu_num);
        mVideoIntroduction = (TextView) mRootView.findViewById(R.id.video_detail_description);
        mVideoShareNum = (TextView) mRootView.findViewById(R.id.video_share_num);
        mVideoCoins = (TextView) mRootView.findViewById(R.id.video_coin_num);
        mVideoFavorites = (TextView) mRootView.findViewById(R.id.video_collect_num);
        mUserIcon = (CircleImageView) mRootView.findViewById(R.id.video_author);
        mCreateTime = (TextView) mRootView.findViewById(R.id.video_create_time);
        mAttention = (TextView) mRootView.findViewById(R.id.video_attention);
        mTagEdit = (TextView) mRootView.findViewById(R.id.video_tag_edit);
        mTagsLayout = (TagFlowLayout) mRootView.findViewById(R.id.video_detail_tags);
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void initEvent() {
    }
}
