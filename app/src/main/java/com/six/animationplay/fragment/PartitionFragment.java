package com.six.animationplay.fragment;

import android.view.View;
import android.widget.AdapterView;

import com.six.animationplay.R;
import com.six.animationplay.presenters.partition.PartitionAdapter;
import com.six.animationplay.widgets.MyGridView;

/**
 * Created by Administrator on 2017/3/30.
 */

public class PartitionFragment extends BaseFragment {

    private MyGridView mGridView;
    private PartitionAdapter mAdapter;
    private int[] mPictures = {R.drawable.ic_category_bangumi,
            R.drawable.ic_category_animate, R.drawable.ic_category_bangumi_chinese,
            R.drawable.ic_category_music, R.drawable.ic_category_dance,
            R.drawable.ic_category_game, R.drawable.ic_category_tec,
            R.drawable.ic_category_life, R.drawable.ic_category_fa,
            R.drawable.ic_category_fan, R.drawable.ic_category_film, R.drawable.ic_category_tv};

    public PartitionFragment() {
    }

    public static PartitionFragment newInstance() {
        return new PartitionFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_partition_layout;
    }

    @Override
    protected void initView() {
        mGridView = (MyGridView) mRootView.findViewById(R.id.partition_grid_view);
    }

    @Override
    protected void initData() {
        String[] partitions = getResources().getStringArray(R.array.partition_list);
        mAdapter = new PartitionAdapter(mActivity, partitions, mPictures);
        mGridView.setAdapter(mAdapter);
    }

    @Override
    protected void initEvent() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = mAdapter.getItem(position);
            }
        });
    }
}
