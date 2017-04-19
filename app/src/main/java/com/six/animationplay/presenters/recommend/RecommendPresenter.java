package com.six.animationplay.presenters.recommend;

import android.util.Log;

import com.six.animationplay.apiservice.NetService;
import com.six.animationplay.model.RecommendListBean;

import rx.Observer;

/**
 * Created by Administrator on 2017/3/31.
 */

public class RecommendPresenter implements RecommendContract.Presenter {

    private RecommendContract.View mRecommendView;

    public RecommendPresenter(RecommendContract.View recommendView) {
        this.mRecommendView = recommendView;
        mRecommendView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void getRecommends() {
        NetService.getRecommends(new Observer<RecommendListBean>() {
            @Override
            public void onCompleted() {
                mRecommendView.getRecommendFinish();
            }

            @Override
            public void onError(Throwable e) {
                mRecommendView.getRecommendFinish();
            }

            @Override
            public void onNext(RecommendListBean recommendListBean) {
                if (recommendListBean != null) {
                    mRecommendView.updateRecommendData(recommendListBean);
                }
            }
        });
    }
}
