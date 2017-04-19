package com.six.animationplay.fragment;

import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.six.animationplay.R;
import com.six.animationplay.listeners.MyItemTouchListener;
import com.six.animationplay.model.BiliLiveIndexBean;
import com.six.animationplay.presenters.biliLive.BiliLiveContract;
import com.six.animationplay.widgets.banner.BannerView;

import java.text.DecimalFormat;

/**
 * Created by Administrator on 2017/3/30.
 */

public class BiliLiveFragment extends BaseFragment implements BiliLiveContract.View,
        SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mLiveSwipeRefreshLayout;
    private RecyclerView mLiveRecyclerView;
    private BiliLiveContract.Presenter mPresenter;
    private BiliLiveRecyclerViewAdapter mAdapter;

    public BiliLiveFragment() {
    }

    public static BiliLiveFragment newInstance() {
        return new BiliLiveFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bili_live_layout;
    }

    @Override
    protected void initView() {
        mLiveSwipeRefreshLayout = (SwipeRefreshLayout) mRootView.findViewById(R.id.bili_live_refresh);
        mLiveRecyclerView = (RecyclerView) mRootView.findViewById(R.id.bili_live_view);
    }

    @Override
    protected void initData() {
        mAdapter = new BiliLiveRecyclerViewAdapter();
        //设置布局管理器
        GridLayoutManager layout = new GridLayoutManager(mActivity, 12);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {

            @Override
            public int getSpanSize(int position) {
                return mAdapter.getSpanSize(position);
            }
        });
        //设置adapter
        mLiveRecyclerView.setAdapter(mAdapter);
        mLiveRecyclerView.setLayoutManager(layout);
    }

    @Override
    protected void initEvent() {
        mLiveSwipeRefreshLayout.setOnRefreshListener(this);

        mLiveRecyclerView.addOnItemTouchListener(new MyItemTouchListener(mLiveRecyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder holder, int position) {
                /*if (holder instanceof LiveBannerViewHolder) {
                } else if (holder instanceof LiveEntranceViewHolder) {
                } else if (holder instanceof LivePartitionViewHolder) {
                } else if (holder instanceof LiveItemViewHolder) {
                }*/
            }
        });

        mLiveSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                mLiveSwipeRefreshLayout.setRefreshing(true);
                onRefresh();
            }
        });
    }

    @Override
    public void onRefresh() {
        mPresenter.getLiveIndexFromNet();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(BiliLiveContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void getLiveInfoSuccess(BiliLiveIndexBean.DataBean dataBean) {
        if (dataBean != null) {
            mAdapter.updateBiliLiveData(dataBean);
        }
    }

    @Override
    public void getLiveInfoComplete() {
        mLiveSwipeRefreshLayout.setRefreshing(false);
    }

    private class BiliLiveRecyclerViewAdapter extends RecyclerView.Adapter {

        private BiliLiveIndexBean.DataBean mBiliLiveBeans;
        private int mEntrances = 0;
        private int mRecommendSize = 0;

        private static final int TYPE_ENTRANCE = 0;     //快速入口
        private static final int TYPE_LIVE_ITEM = 1;    //直播Item
        private static final int TYPE_PARTITION = 2;    //分类Title
        private static final int TYPE_BANNER = 3;       //直播页Banner
        private static final int TYPE_LIVE_RECOMMEND_BANNER = 4;    //主播推荐Banner


        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            switch (viewType) {
                case TYPE_BANNER:
                    view = mInflater.inflate(R.layout.item_live_banner, null);
                    return new LiveBannerViewHolder(view);
                case TYPE_ENTRANCE:
                    view = mInflater.inflate(R.layout.item_live_entrance, null);
                    return new LiveEntranceViewHolder(view);
                case TYPE_PARTITION:
                    view = mInflater.inflate(R.layout.item_live_partition, null);
                    return new LivePartitionViewHolder(view);
                default:
                    view = mInflater.inflate(R.layout.item_live_live_item, null);
                    return new LiveItemViewHolder(view);
            }
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (mBiliLiveBeans != null) {
                if (holder instanceof LiveBannerViewHolder) {
                    LiveBannerViewHolder viewHolder = (LiveBannerViewHolder) holder;
                    viewHolder.mBannerView.delayTime(5).build(mBiliLiveBeans.getBanner());
                } else if (holder instanceof LiveEntranceViewHolder) {
                    LiveEntranceViewHolder viewHolder = (LiveEntranceViewHolder) holder;
                    viewHolder.mTitle.setText(mBiliLiveBeans.getPartitions().get(position - 1)
                            .getPartition().getName());
                    Glide.with(mActivity).load(mBiliLiveBeans.getPartitions().get(position - 1)
                            .getPartition().getSub_icon().getSrc()).into(viewHolder.mIcon);
                } else if (holder instanceof LivePartitionViewHolder) {
                    LivePartitionViewHolder viewHolder = (LivePartitionViewHolder) holder;
                    if (position == 10) {
                        Glide.with(mActivity).load(mBiliLiveBeans.getRecommend_data()
                                .getPartition().getSub_icon().getSrc()).into(viewHolder.mIcon);
                        viewHolder.mTitle.setText(mBiliLiveBeans.getRecommend_data()
                                .getPartition().getName());
                        viewHolder.mCount.setText("当前" +
                                mBiliLiveBeans.getRecommend_data().getPartition().getCount() + "个直播>");
                    } else {
                        Glide.with(mActivity).load(mBiliLiveBeans.getPartitions()
                                .get(partitionCol(position)).getPartition()
                                .getSub_icon().getSrc()).into(viewHolder.mIcon);
                        viewHolder.mTitle.setText(mBiliLiveBeans.getPartitions().get(partitionCol(position))
                                .getPartition().getName());
                        viewHolder.mCount.setText("当前" +
                                mBiliLiveBeans.getPartitions().get(partitionCol(position))
                                        .getPartition().getCount() + "个直播>");
                    }
                } else if (holder instanceof LiveItemViewHolder) {
                    LiveItemViewHolder viewHolder = (LiveItemViewHolder) holder;
                    String liveTitle;
                    String title;
                    String partitionTitle;
                    String userName;
                    int watcher;
                    String coverUrl;

                    if (position == 17) {
                        title = mBiliLiveBeans.getRecommend_data().getBanner_data().get(0).getTitle();
                        partitionTitle = "#" + mBiliLiveBeans.getRecommend_data().getBanner_data()
                                .get(0).getArea() + "#";
                        userName = title;
                        watcher = mBiliLiveBeans.getRecommend_data().getBanner_data().get(0).getOnline();
                        coverUrl = mBiliLiveBeans.getRecommend_data().getBanner_data().get(0).getCover().getSrc();
                    } else {
                        if (partitionCol(position) == -1) {
                            int pos = 0;
                            if (position < 17) {
                                pos = position - 1 - mEntrances - 1;
                            } else {
                                pos = position - 1 - mEntrances - 1 - 1;
                            }

                            title = mBiliLiveBeans.getRecommend_data().getLives().get(pos).getTitle();
                            partitionTitle = "#" + mBiliLiveBeans.getRecommend_data().getLives().get(pos).getArea() + "#";
                            userName = mBiliLiveBeans.getRecommend_data().getLives().get(pos).getOwner().getName();
                            watcher = mBiliLiveBeans.getRecommend_data().getLives().get(pos).getOnline();
                            coverUrl = mBiliLiveBeans.getRecommend_data().getLives().get(pos).getCover().getSrc();
                        } else {
                            int pos = (position - 1 - mEntrances - 1 - mRecommendSize) % 5 - 1;
                            title = mBiliLiveBeans.getPartitions().get(partitionCol(position))
                                    .getLives().get(pos).getTitle();
                            partitionTitle = "";
                            userName = mBiliLiveBeans.getPartitions().get(partitionCol(position))
                                    .getLives().get(pos).getOwner().getName();
                            watcher = mBiliLiveBeans.getPartitions().get(partitionCol(position))
                                    .getLives().get(pos).getOnline();
                            coverUrl = mBiliLiveBeans.getPartitions().get(partitionCol(position))
                                    .getLives().get(pos).getCover().getSrc();
                        }
                    }

                    if (!TextUtils.isEmpty(partitionTitle)) {
                        liveTitle = partitionTitle + title;
                        SpannableString spanString = new SpannableString(liveTitle);
                        spanString.setSpan(new ForegroundColorSpan(Color.parseColor("#FA7198")),
                                0, partitionTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        spanString.setSpan(new ForegroundColorSpan(Color.parseColor("#555555")),
                                partitionTitle.length(), liveTitle.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

                        viewHolder.mTitle.setText(spanString);
                    } else {
                        viewHolder.mTitle.setText(title);
                    }

                    viewHolder.mUserName.setText(userName);
                    viewHolder.mWatcher.setText(" " + parseWatcher(watcher) + "");
                    Glide.with(mActivity).load(coverUrl)
                            .placeholder(R.drawable.live_default_image)
                            .error(R.drawable.live_default_image)
                            .into(viewHolder.mIcon);
                }
            }
        }

        public void updateBiliLiveData(BiliLiveIndexBean.DataBean bean) {
            mBiliLiveBeans = bean;
            mEntrances = mBiliLiveBeans.getPartitions().size();
            mRecommendSize = mBiliLiveBeans.getRecommend_data().getLives().size() + 1;
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            if (mBiliLiveBeans != null) {
                return mBiliLiveBeans.getPartitions().size() * 6 +
                        mBiliLiveBeans.getRecommend_data().getLives().size() + 1 + 1 + 1;
            } else {
                return 0;
            }
        }

        public int getSpanSize(int position) {
            int viewType = getItemViewType(position);
            switch (viewType) {
                case TYPE_ENTRANCE:
                    return 3;
                case TYPE_LIVE_ITEM:
                    return 6;
                case TYPE_PARTITION:
                    return 12;
                case TYPE_BANNER:
                    return 12;
                case TYPE_LIVE_RECOMMEND_BANNER:
                    return 12;
            }
            return 0;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0) {
                return TYPE_BANNER;
            } else if (position < mEntrances + 1) {
                return TYPE_ENTRANCE;
            } else if (isClickPartitionTitle(position)) {
                return TYPE_PARTITION;
            } else if (position == 17) {
                return TYPE_LIVE_RECOMMEND_BANNER;
            } else {
                return TYPE_LIVE_ITEM;
            }
        }

        private int partitionCol(int position) {
            if (position - 1 - mEntrances - mRecommendSize <= 0) {
                return -1;
            } else {
                position -= 1 + mEntrances + mRecommendSize + 1;
                return position / 5;
            }
        }

        private boolean isClickPartitionTitle(int position) {
            int pos = position - mEntrances - mRecommendSize - 1 - 1;
            return (position == 10) || (pos >= 0 && pos % 5 == 0);
        }
    }

    private class LiveBannerViewHolder extends RecyclerView.ViewHolder {
        public BannerView mBannerView;

        public LiveBannerViewHolder(View itemView) {
            super(itemView);

            mBannerView = (BannerView) itemView.findViewById(R.id.item_live_banner);
        }
    }

    private class LiveEntranceViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIcon;
        private TextView mTitle;

        public LiveEntranceViewHolder(View itemView) {
            super(itemView);

            mIcon = (ImageView) itemView.findViewById(R.id.item_live_entrance_image);
            mTitle = (TextView) itemView.findViewById(R.id.item_live_entrance_text);
        }
    }

    private class LivePartitionViewHolder extends RecyclerView.ViewHolder {

        private ImageView mIcon;
        private TextView mTitle;
        private TextView mCount;

        public LivePartitionViewHolder(View itemView) {
            super(itemView);

            mIcon = (ImageView) itemView.findViewById(R.id.item_live_partition_icon);
            mTitle = (TextView) itemView.findViewById(R.id.item_live_partition_title);
            mCount = (TextView) itemView.findViewById(R.id.item_live_partition_count);
        }
    }

    private class LiveItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView mIcon;
        private TextView mTitle;
        private TextView mUserName;
        private TextView mWatcher;

        public LiveItemViewHolder(View itemView) {
            super(itemView);

            mIcon = (ImageView) itemView.findViewById(R.id.item_live_item_icon);
            mTitle = (TextView) itemView.findViewById(R.id.item_live_item_title);
            mUserName = (TextView) itemView.findViewById(R.id.item_live_item_username);
            mWatcher = (TextView) itemView.findViewById(R.id.item_live_item_watcher);
        }
    }

    public String parseWatcher(int watcher) {
        String tmp;
        if (watcher > 10100) {
            DecimalFormat decimalFormat = new DecimalFormat(".00");
            float t = watcher / 10000.0f;
            tmp = decimalFormat.format(t) + "万";
        } else {
            tmp = String.valueOf(watcher);
        }
        return tmp;
    }
}
