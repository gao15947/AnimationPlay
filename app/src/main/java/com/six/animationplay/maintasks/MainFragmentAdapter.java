package com.six.animationplay.maintasks;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.six.animationplay.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/30.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {

    private List<Fragment> mFragmentList;
    private List<String> mTabNames;

    public MainFragmentAdapter(FragmentManager fm, List<Fragment> fragments, List<String> tabNames) {
        super(fm);
        mFragmentList = fragments;
        mTabNames = tabNames;
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
        return mTabNames.get(position);
    }
}
