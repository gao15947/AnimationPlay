package com.six.animationplay.presenters.videoDetail;

import com.six.animationplay.apiservice.NetService;
import com.six.animationplay.model.VideoDetailBean;
import com.six.animationplay.utils.CommonUtils;
import com.six.animationplay.utils.EncodeSignUtils;

import java.util.HashMap;
import java.util.Map;

import rx.Observer;

/**
 * Created by Administrator on 2017/4/14.
 */

public class VideoDetailPresenter implements VideoDetailContract.Presenter {

    private VideoDetailContract.View mVideoDetailView;

    public VideoDetailPresenter(VideoDetailContract.View videoDetailView) {
        this.mVideoDetailView = videoDetailView;
        mVideoDetailView.setPresenter(this);
    }

    @Override
    public void start() {
    }

    @Override
    public void getVideoDetailById(String id) {
        Map<String, String> map = new HashMap<>();
        map.put("appkey", CommonUtils.APP_KEY);
        map.put("id", id);
        map.put("page", "1");

        String sign = EncodeSignUtils.encodeSign(map, CommonUtils.APP_SECRET);

        NetService.getVideoDetailById(CommonUtils.APP_KEY, id, "1", sign,
                new Observer<VideoDetailBean>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(VideoDetailBean detailBean) {
                if (detailBean != null) {
                    mVideoDetailView.getVideoDetailSuccess(detailBean);
                }
            }
        });
    }
}
