package com.six.animationplay.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.six.animationplay.R;
import com.six.animationplay.model.RecommendListBean;
import com.six.animationplay.presenters.recommend.RecommendContract;
import com.six.animationplay.widgets.MyGridView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */

public class RecommendFragment extends BaseFragment implements RecommendContract.View, SwipeRefreshLayout.OnRefreshListener {

    private RecommendContract.Presenter mPresenter;
    private RecommendAdapter mAdapter;
    private MyGridView mRecommendGridView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public RecommendFragment() {
    }

    public static RecommendFragment newInstance() {
        return new RecommendFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_recommend_layout;
    }

    @Override
    protected void initView() {
        mSwipeRefreshLayout = (SwipeRefreshLayout) mRootView.findViewById(R.id.refresh_layout);
        mRecommendGridView = (MyGridView) mRootView.findViewById(R.id.home_recommend_view);
    }

    @Override
    protected void initData() {
        mAdapter = new RecommendAdapter();
        mRecommendGridView.setAdapter(mAdapter);
    }

    @Override
    protected void initEvent() {
        mSwipeRefreshLayout.setOnRefreshListener(this);

        mRecommendGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RecommendListBean.ListBean bean = mAdapter.getItem(position);
            }
        });

        mSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(true);
                onRefresh();
            }
        });
    }

    @Override
    public void setPresenter(RecommendContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void updateRecommendData(RecommendListBean bean) {
        if (mAdapter != null) {
            mAdapter.updateRecommendData(bean.getList());
        }
    }

    @Override
    public void getRecommendFinish() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        mPresenter.getRecommends();
    }

    private class RecommendAdapter extends BaseAdapter {
        public List<RecommendListBean.ListBean> mRecommendList;

        RecommendAdapter() {
            mRecommendList = new ArrayList<>();
        }

        public void updateRecommendData(List<RecommendListBean.ListBean> recommendList) {
            mRecommendList.clear();
            mRecommendList.addAll(recommendList);
            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return mRecommendList.size();
        }

        @Override
        public RecommendListBean.ListBean getItem(int position) {
            return mRecommendList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.card_item_home_common, parent, false);
                holder = new ViewHolder();

                holder.mVideoIcon = (ImageView) convertView.findViewById(R.id.video_preview);
                holder.mVideoTitle = (TextView) convertView.findViewById(R.id.video_title);
                holder.mVideoStyle = (TextView) convertView.findViewById(R.id.video_style);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            RecommendListBean.ListBean bean = getItem(position);
            if (bean != null) {
                holder.mVideoTitle.setText(bean.getTitle());
                Glide.with(mActivity).load(bean.getPic())
                        .placeholder(R.drawable.live_default_image)
                        .error(R.drawable.live_default_image)
                        .into(holder.mVideoIcon);
                holder.mVideoStyle.setText(bean.getTypename());
            }

            return convertView;
        }

        class ViewHolder {
            ImageView mVideoIcon;
            TextView mVideoTitle;
            TextView mVideoStyle;
        }
    }
}
