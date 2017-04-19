package com.six.animationplay.presenters.search;

import android.util.Log;

import com.six.animationplay.apiservice.NetService;
import com.six.animationplay.model.SearchResultBean;
import com.six.animationplay.utils.CommonUtils;
import com.six.animationplay.utils.EncodeSignUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;

/**
 * Created by Administrator on 2017/4/13.
 */

public class SearchPresenter implements SearchContract.Presenter {

    private SearchContract.View mSearchView;

    public SearchPresenter(SearchContract.View searchView) {
        this.mSearchView = searchView;
        mSearchView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void searchVideoByTag(String tag) {
        String encoder = null;
        try {
            encoder = URLEncoder.encode(tag, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String, String> map = new HashMap<>();
        map.put("appkey", CommonUtils.APP_KEY);
        map.put("keyword", encoder);

        String sign = EncodeSignUtils.encodeSign(map, CommonUtils.APP_SECRET);

        NetService.searchVideoByKeyWord(CommonUtils.APP_KEY, tag, sign,
                new Observer<SearchResultBean>() {
                    @Override
                    public void onCompleted() {
                        mSearchView.searchResultCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mSearchView.searchResultCompleted();
                    }

                    @Override
                    public void onNext(SearchResultBean searchResultBean) {
                        mSearchView.searchResultSuccess(searchResultBean);
                    }
                });

    }
}
