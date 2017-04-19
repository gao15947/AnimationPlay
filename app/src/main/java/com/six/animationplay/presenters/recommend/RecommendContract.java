package com.six.animationplay.presenters.recommend;

import com.six.animationplay.interfaces.BasePresenter;
import com.six.animationplay.interfaces.BaseView;
import com.six.animationplay.model.RecommendListBean;

/**
 * Created by Administrator on 2017/3/31.
 */

public interface RecommendContract {
    interface View extends BaseView<Presenter> {
        void updateRecommendData(RecommendListBean bean);
        void getRecommendFinish();
    }

    interface Presenter extends BasePresenter {
        void getRecommends();
    }
}
