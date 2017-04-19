package com.six.animationplay.presenters.videoDetail;

import com.six.animationplay.interfaces.BasePresenter;
import com.six.animationplay.interfaces.BaseView;
import com.six.animationplay.model.VideoDetailBean;

/**
 * Created by Administrator on 2017/4/14.
 */

public interface VideoDetailContract {
    interface View extends BaseView<Presenter> {
        void getVideoDetailSuccess(VideoDetailBean detailBean);
    }

    interface Presenter extends BasePresenter {
        void getVideoDetailById(String id);
    }
}
