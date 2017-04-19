package com.six.animationplay.presenters.search;

import com.six.animationplay.interfaces.BasePresenter;
import com.six.animationplay.interfaces.BaseView;
import com.six.animationplay.model.SearchResultBean;

/**
 * Created by Administrator on 2017/4/13.
 */

public interface SearchContract {
    interface View extends BaseView<Presenter> {
        void searchResultSuccess(SearchResultBean resultBean);
        void searchResultCompleted();
    }

    interface Presenter extends BasePresenter {
        void searchVideoByTag(String tag);
    }
}
