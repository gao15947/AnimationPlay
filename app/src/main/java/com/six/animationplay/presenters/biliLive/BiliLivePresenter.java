package com.six.animationplay.presenters.biliLive;

import com.six.animationplay.apiservice.NetService;
import com.six.animationplay.model.BiliLiveIndexBean;

import rx.Observer;

/**
 * Created by Administrator on 2017/4/1.
 */

public class BiliLivePresenter implements BiliLiveContract.Presenter {

    private BiliLiveContract.View mBiliLiveView;

    public BiliLivePresenter(BiliLiveContract.View biliLiveView) {
        this.mBiliLiveView = biliLiveView;
        mBiliLiveView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void getLiveIndexFromNet() {
        NetService.getBiliLiveIndex(new Observer<BiliLiveIndexBean>() {
            @Override
            public void onCompleted() {
                mBiliLiveView.getLiveInfoComplete();
            }

            @Override
            public void onError(Throwable e) {
                mBiliLiveView.getLiveInfoComplete();
            }

            @Override
            public void onNext(BiliLiveIndexBean biliLiveIndexBean) {
                mBiliLiveView.getLiveInfoSuccess(biliLiveIndexBean.getData());
            }
        });
    }
}
