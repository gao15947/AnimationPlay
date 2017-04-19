package com.six.animationplay.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2017/3/30.
 */

public abstract class BaseFragment extends Fragment {

    protected View mRootView;
    protected FragmentActivity mActivity;
    protected LayoutInflater mInflater;

    protected abstract
    @LayoutRes
    int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        mActivity = getActivity();
        mInflater = inflater;
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initEvent();
}
