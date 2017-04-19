package com.six.animationplay.maintasks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.six.animationplay.R;
import com.six.animationplay.fragment.BiliLiveFragment;
import com.six.animationplay.fragment.PartitionFragment;
import com.six.animationplay.fragment.RecommendFragment;
import com.six.animationplay.fragment.SearchFragment;
import com.six.animationplay.presenters.biliLive.BiliLivePresenter;
import com.six.animationplay.presenters.recommend.RecommendPresenter;
import com.six.animationplay.presenters.search.SearchPresenter;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Administrator on 2017/3/24.
 */

public class MainFragment extends Fragment {
    private View mRootView;

    public MainFragment() {
    }

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main_layout, container, false);

        setActionBar();
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = (TabLayout) mRootView.findViewById(R.id.home_tab);
        ViewPager viewPager = (ViewPager) mRootView.findViewById(R.id.home_view_pager);
        List<String> tabNames = new ArrayList<>();
        List<Fragment> fragments = new ArrayList<>();
        String[] names = getResources().getStringArray(R.array.home_list);
        for (int i = 0; i < names.length; i++) {
            if (i == 0) {
                BiliLiveFragment biliLiveFragment = BiliLiveFragment.newInstance();
                new BiliLivePresenter(biliLiveFragment);
                tabNames.add(names[i]);
                fragments.add(biliLiveFragment);
            } else if (i == 1) {
                RecommendFragment recommendFragment = RecommendFragment.newInstance();
                new RecommendPresenter(recommendFragment);
                tabNames.add(names[i]);
                fragments.add(recommendFragment);
            } else if (i == 2) {
                PartitionFragment partitionFragment = PartitionFragment.newInstance();
                tabNames.add(names[i]);
                fragments.add(partitionFragment);
            } else if (i == 3) {
                SearchFragment searchFragment = SearchFragment.newInstance();
                new SearchPresenter(searchFragment);
                tabNames.add(names[i]);
                fragments.add(searchFragment);
            }
        }

        MainFragmentAdapter adapter = new MainFragmentAdapter(getChildFragmentManager(), fragments, tabNames);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setActionBar() {
        Toolbar toolbar = (Toolbar) mRootView.findViewById(R.id.home_top_bar);
        toolbar.setLogo(R.drawable.ic_bili_logo_white);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar ab = ((MainActivity) getActivity()).getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
            ab.setDisplayUseLogoEnabled(true);
            ab.setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
