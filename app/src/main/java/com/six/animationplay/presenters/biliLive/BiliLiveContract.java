package com.six.animationplay.presenters.biliLive;

import com.six.animationplay.interfaces.BasePresenter;
import com.six.animationplay.interfaces.BaseView;
import com.six.animationplay.model.BiliLiveIndexBean;

/**
 * Created by Administrator on 2017/4/1.
 */

public interface BiliLiveContract {
    interface View extends BaseView<Presenter> {
        void getLiveInfoSuccess(BiliLiveIndexBean.DataBean dataBean);
        void getLiveInfoComplete();
    }

    interface Presenter extends BasePresenter {
        void getLiveIndexFromNet();
    }
}
