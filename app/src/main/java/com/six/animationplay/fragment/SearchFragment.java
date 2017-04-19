package com.six.animationplay.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.six.animationplay.R;
import com.six.animationplay.activities.CustomScanActivity;
import com.six.animationplay.model.SearchResultBean;
import com.six.animationplay.presenters.search.SearchContract;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */

public class SearchFragment extends BaseFragment implements SearchContract.View {

    private LinearLayout mEditLayout;
    private ImageView mQRScanBtn;
    private TagFlowLayout mTagFlowLayout;
    private LinearLayout mTagMore;
    private LinearLayout mActivityCenter;
    private LinearLayout mTopicCenter;
    private LinearLayout mBlackListCenter;
    private LinearLayout mRankOriginal;
    private LinearLayout mRankAll;

    private MyTagAdapter mTagAdapter;

    private List<String> mTagList = Arrays.asList("全职高手", "人民的名义", "电影", "自由之翼",
            "暴走大事件", "王者荣耀", "人渣的本愿", "小林家的龙女仆", "大司马", "火影忍者",
            "主播真会玩", "进击的巨人第二季", "电视", "狐妖小红娘", "阴阳师", "极乐净土",
            "通灵之战", "逗鱼时刻", "英雄联盟", "崩坏3", "主播炸了", "嗨氏", "三世情缘",
            "武林外传", "狐狸的夏天", "炉石传说", "守望先锋", "Re:creators", "从零开始的魔法书",
            "埃罗芒阿老师", "瞎看什么", "暴走大事件", "战舰少女R");

    private SearchContract.Presenter mPresenter;

    public SearchFragment() {
    }

    public static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_search_layout;
    }

    @Override
    protected void initView() {
        mEditLayout = (LinearLayout) mRootView.findViewById(R.id.search_edit_layout);
        mQRScanBtn = (ImageView) mRootView.findViewById(R.id.search_qr_code);
        mTagFlowLayout = (TagFlowLayout) mRootView.findViewById(R.id.search_tags_layout);
        mTagMore = (LinearLayout) mRootView.findViewById(R.id.search_tag_more);
        mActivityCenter = (LinearLayout) mRootView.findViewById(R.id.search_activity_center);
        mTopicCenter = (LinearLayout) mRootView.findViewById(R.id.search_topic_center);
        mBlackListCenter = (LinearLayout) mRootView.findViewById(R.id.search_black_list_center);
        mRankOriginal = (LinearLayout) mRootView.findViewById(R.id.search_rank_original);
        mRankAll = (LinearLayout) mRootView.findViewById(R.id.search_rank_all);
    }

    @Override
    protected void initData() {
        mTagAdapter = new MyTagAdapter(mTagList);
        mTagFlowLayout.setAdapter(mTagAdapter);
    }

    @Override
    protected void initEvent() {
        mTagMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTagAdapter != null) {
                    mTagAdapter.setEnterMore(!mTagAdapter.isEnterMore());
                }
            }
        });

        mQRScanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customScan();
            }
        });

        mTagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                String s = mTagList.get(position);
                mPresenter.searchVideoByTag(s);
                return false;
            }
        });
    }

    public void customScan() {
        IntentIntegrator intentIntegrator = IntentIntegrator.forSupportFragment(SearchFragment.this);
        intentIntegrator.setOrientationLocked(false).setCaptureActivity(CustomScanActivity.class)
                .setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES)
                .initiateScan();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (intentResult != null) {
            if (intentResult.getContents() != null) {
                String ScanResult = intentResult.getContents();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void searchResultSuccess(SearchResultBean resultBean) {
    }

    @Override
    public void searchResultCompleted() {
    }

    private class MyTagAdapter extends TagAdapter<String> {

        private boolean isEnterMore = false;

        MyTagAdapter(List<String> datas) {
            super(datas);
        }

        public boolean isEnterMore() {
            return isEnterMore;
        }

        public void setEnterMore(boolean enterMore) {
            isEnterMore = enterMore;
            notifyDataChanged();
        }

        @Override
        public int getCount() {
            return !isEnterMore ? 7 : super.getCount();
        }

        @Override
        public View getView(FlowLayout parent, int position, String s) {
            TextView textView = (TextView) LayoutInflater.from(mActivity)
                    .inflate(R.layout.item_tags_layout, parent, false);
            textView.setText(s);
            return textView;
        }
    }
}
